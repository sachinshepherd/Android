package com.example.kbc_game;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class db4 extends SQLiteOpenHelper {
	
	static String DBNAME="mydb";
	static String tblnamel2="mloginTable";
	static String col1="username";
	static String col2="pwd";
	static String col3="us";
	static String col4="pd";
	
	public db4(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DBNAME, null, 1);
		
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		
		String query="CREATE TABLE "+tblnamel2+"("+col1+" text,"+col2+" text,"+col3+" text,"+col4+" text)";
		arg0.execSQL(query);
		
	}
	
	public void inRecords(String uName,String pass,String ue,String ps)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		String s="insert into "+tblnamel2 + " values('"+uName+"','"+pass+"','"+ue+"','"+ps+"');";
		db.execSQL(s);
	}
	
	public Cursor getAllTitles()
	{
		SQLiteDatabase db=this.getWritableDatabase();
		return db.rawQuery("select * from "+tblnamel2, null);
	}
	
	/*public Cursor selRecs(String un,String pass)
	{
		Cursor cur;
		SQLiteDatabase db=this.getReadableDatabase();
		return db.rawQuery("select * from "+tblname+" where username='"+un+"' and pwd='"+pass+"';", null);
	}*/
	
	public Cursor deleteall()
	{
		SQLiteDatabase db=this.getWritableDatabase();
		return db.rawQuery("select * from "+tblnamel2, null);
	}

	     
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//db.delete(tblname, null, null);
	}

}
