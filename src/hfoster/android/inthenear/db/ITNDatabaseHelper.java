package hfoster.android.inthenear.db;

import hfoster.android.inthenear.resources.ITNTrueFalse;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ITNDatabaseHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "inthenear_applicationdata";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "search_terms";
	private static final String COL_ID = "id";
	private static final String COL_LABEL = "label";
	private static final String COL_ACTIVE = "active";
	// DB creation SQL statement -- creates one table
	private static final String DATABASE_CREATE = "create table " + TABLE_NAME 
													+ " if not exists (" + COL_ID 
													+ " integer primary key autoincrement, " + COL_LABEL 
													+ " text not null, " + COL_ACTIVE 
													+ " text not null);";
	// DB setup SQL -- inserts base start data
	private static final String DATABASE_SETUP = "insert into " + TABLE_NAME + " values (0, restaurant, " + ITNTrueFalse.TRUE.getStatus() + "); "
													+ "insert into " + TABLE_NAME + " values (1, museum, " + ITNTrueFalse.TRUE.getStatus() + "); "
													+ "insert into " + TABLE_NAME + " values (2, park, " + ITNTrueFalse.TRUE.getStatus() + ");";

	public ITNDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	// Called during DB creation
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
		database.execSQL(DATABASE_SETUP);
	}

	// Called during DB upgrade - i.e. when DATABASE_VERSION is incremented
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.w(ITNDatabaseHelper.class.getName(), "Upgrade database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data.");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}

}
