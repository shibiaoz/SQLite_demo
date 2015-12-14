package com.imooc.sqlitedemo3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper{
	
	public DBOpenHelper(Context context, String name) {
		super(context, name, null, 1);
		// TODO Auto-generated constructor stub
	}
	public DBOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override//�״δ������ݿ��ʱ����� һ����԰ѽ��� ����Ĳ���
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table if not exists stutb(_id integer primary key autoincrement,name text not null,sex text not null,age integer not null)");
		db.execSQL("insert into stutb(name,sex,age)values('����','Ů',18)");
	}

	@Override//�����ݿ�İ汾�����仯��ʱ�� ���Զ�ִ��
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
