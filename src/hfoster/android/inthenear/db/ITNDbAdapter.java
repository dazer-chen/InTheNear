package hfoster.android.inthenear.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ITNDbAdapter {
	
	// Database fields
	public static final String KEY_ID = "id";
	public static final String KEY_LABEL = "label";
	public static final String KEY_LONGITUDE = "longitude";
	public static final String KEY_LATITUDE = "latitude";
	public static final String KEY_LOC_ID = "loc_id";
	private static final String T1_DATABASE_TABLE = "location";
	private static final String T2_DATABASE_TABLE = "point_of_interest";
	private Context context;
	private SQLiteDatabase database;
	private ITNDatabaseHelper dbHelper;
	
	public ITNDbAdapter(Context context) {
		this.context = context;
	}
	
	public ITNDbAdapter open() throws SQLException {
		dbHelper = new ITNDatabaseHelper(context);
		database = dbHelper.getWritableDatabase();
		return this;
	}
	
	public void close() {
		dbHelper.close();
	}
	
	/*
	 * Create new row. If successful, return the new row ID. Otherwise return -1.
	 */
	public long createRow(String label, double longitude, double latitude, String table) {
		ContentValues initialValues = createContentValues(label, longitude, latitude);
		return database.insert(table, null, initialValues);
	}
	
	public long createRow(String label, double longitude, double latitude, int locId, String table) {
		ContentValues initialValues = createContentValues(label, longitude, latitude, locId);
		return database.insert(table, null, initialValues);
	}
	
	/*
	 * Update a row.
	 */
	public boolean updateRow(long rowId, String label, double longitude, double latitude, String table) {
		ContentValues updateValues = createContentValues(label, longitude, latitude);
		return database.update(table, updateValues, KEY_ID + "=" + rowId, null) > 0;
	}
	
	/*
	 * Delete a row.
	 */
	public boolean deleteRow(long rowId, String table) {
		return database.delete(table, KEY_ID + "=" + rowId, null) > 0;
	}
	
	/*
	 * Return Cursor over all Locations.
	 */
	public Cursor fetchAllLocations() {
		return database.query(T1_DATABASE_TABLE, new String[] { KEY_ID, KEY_LABEL, KEY_LONGITUDE, KEY_LATITUDE }, 
				null, null, null, null, null);
	}
	
	/*
	 * Return Cursor over all points of interest.
	 */
	public Cursor fetchAllPointOfInterest() {
		return database.query(T2_DATABASE_TABLE, new String[] { KEY_ID, KEY_LABEL, KEY_LONGITUDE, KEY_LATITUDE, KEY_LOC_ID }, 
				null, null, null, null, null);
	}
	
	/*
	 * Return Cursor positioned at defined Location.
	 */
	public Cursor fetchLocation(long rowId) throws SQLException {
		Cursor cursor = database.query(true, T1_DATABASE_TABLE, new String[] { KEY_ID, KEY_LABEL, KEY_LONGITUDE, KEY_LATITUDE }, 
				KEY_ID + "=" + rowId, null, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}
	
	/*
	 * Return Cursor positioned at defined point of interest.
	 */
	public Cursor fetchPointOfInterest(long rowId) throws SQLException {
		Cursor cursor = database.query(true, T2_DATABASE_TABLE, new String[] { KEY_ID, KEY_LABEL, KEY_LONGITUDE, KEY_LATITUDE, KEY_LOC_ID },
				KEY_ID + "=" + rowId, null, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}

	private ContentValues createContentValues(String label, double longitude, double latitude) {
		ContentValues values = new ContentValues();
		values.put(KEY_LABEL, label);
		values.put(KEY_LONGITUDE, longitude);
		values.put(KEY_LATITUDE, latitude);
		return values;
	}

	private ContentValues createContentValues(String label, double longitude, double latitude, int locId) {
		ContentValues values = new ContentValues();
		values.put(KEY_LABEL, label);
		values.put(KEY_LONGITUDE, longitude);
		values.put(KEY_LATITUDE, latitude);
		values.put(KEY_LOC_ID, locId);
		return values;
	}
}
