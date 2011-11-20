package hfoster.android.inthenear.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ITNDatabaseHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "inthenear_applicationdata";
	private static final int DATABASE_VERSION = 1;
	// DB creation SQL statement -- creates two tables; location and point_of_interest
	private static final String DATABASE_CREATE = "create table location (id integer primary key autoincrement, label text not null, longitude numeric not null, latitude numeric not null);"
		+ "create table point_of_interest (id integer primary key autoincrement, label text not null, longitude numeric not null, latitude numeric not null, loc_id integer not null);";

	public ITNDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	// Called during DB creation
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	// Called during DB upgrade - i.e. when DATABASE_VERSION is incremented
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.w(ITNDatabaseHelper.class.getName(), "Upgrade database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data.");
		database.execSQL("DROP TABLE IF EXISTS location");
		database.execSQL("DROP TABLE IF EXISTS point_of_interest");
		onCreate(database);
	}

}
