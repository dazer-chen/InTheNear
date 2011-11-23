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
	public static final String KEY_ACTIVE = "active";
	private static final String DATABASE_TABLE = "search_terms";
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
	public long createRow(String label, String active, String table) {
		ContentValues initialValues = createContentValues(label, active);
		return database.insert(table, null, initialValues);
	}
	
	/*
	 * Update a row.
	 */
	public boolean updateRow(long rowId, String label, String active, String table) {
		ContentValues updateValues = createContentValues(label, active);
		return database.update(table, updateValues, KEY_ID + "=" + rowId, null) > 0;
	}
	
	/*
	 * Delete a row.
	 */
	public boolean deleteRow(long rowId, String table) {
		return database.delete(table, KEY_ID + "=" + rowId, null) > 0;
	}
	
	/*
	 * Return Cursor over all search terms.
	 */
	public Cursor fetchAllSearchTerms() {
		return database.query(DATABASE_TABLE, new String[] { KEY_ID, KEY_LABEL, KEY_ACTIVE }, 
				null, null, null, null, null);
	}
	
	/*
	 * Return Cursor positioned at defined search term.
	 */
	public Cursor fetchSearchTerm(long rowId) throws SQLException {
		Cursor cursor = database.query(true, DATABASE_TABLE, new String[] { KEY_ID, KEY_LABEL, KEY_ACTIVE }, 
				KEY_ID + "=" + rowId, null, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}
	
	private ContentValues createContentValues(String label, String active) {
		ContentValues values = new ContentValues();
		values.put(KEY_LABEL, label);
		values.put(KEY_ACTIVE, active);
		return values;
	}

}
