package com.moby.vybori2014;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = "mydatabase.db";
	public static final int DATABASE_VERSION = 1;
	private static final String DATABASE_TABLE = "game";
	public static final String SCORE_NAME_COLUMN = "record_score";
	
	private static final String DATABASE_CREATE_SCRIPT = "create table "
			+ DATABASE_TABLE + " (_id integer primary key autoincrement, " +SCORE_NAME_COLUMN+ " text);";
	private static final String DATABASE_INSERT_SCRIPT = "INSERT INTO game VALUES ('1','Çהוסü למזורü בûעü עû!');";

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DATABASE_CREATE_SCRIPT);
		db.execSQL(DATABASE_INSERT_SCRIPT);
		

	}

	@SuppressLint("NewApi")
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.close();

	}

}
