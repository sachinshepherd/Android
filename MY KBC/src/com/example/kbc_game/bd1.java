package com.example.kbc_game;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class bd1 extends SQLiteOpenHelper {
	
	static String DBNAME="my";
	static String tblname="loginTable";
	static String col1="u";
	static String col2="p";
	
	public bd1(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DBNAME, null, 1);
		
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		
		String query="CREATE TABLE "+tblname+"("+col1+" text,"+col2+" text)";
		arg0.execSQL(query);
		
	}
	
	public void inRecords(String uName,String pass)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		String s="insert into "+tblname + " values('"+uName+"','"+pass+"');";
		db.execSQL(s);
	}
	
	public Cursor getAllTitles()
	{
		SQLiteDatabase db=this.getWritableDatabase();
		return db.rawQuery("select * from "+tblname, null);
	}
	
	public Cursor selRecs(String un,String pass)
	{
		Cursor cur;
		SQLiteDatabase db=this.getReadableDatabase();
		return db.rawQuery("select * from "+tblname+" where u='"+un+"' and p='"+pass+"';", null);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//db.delete(tblname, null, null);
	}

}
