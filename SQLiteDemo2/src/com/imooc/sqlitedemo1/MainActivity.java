package com.imooc.sqlitedemo2;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SQLiteDatabase db = openOrCreateDatabase("stu.db", MODE_PRIVATE, null);
		db.execSQL("create table if not exists stutb(_id integer primary key autoincrement,name text not null,sex text not null,age integer not null)");
		ContentValues values = new ContentValues();
		values.put("name", "����");
		values.put("sex", "��");
		values.put("age", 19);
		long rowId = db.insert("stutb", null, values);
		values.clear();
		values.put("name", "������");
		values.put("sex", "��");
		values.put("age", 99);
		db.insert("stutb", null, values);
		values.clear();
		values.put("name", "������");
		values.put("sex", "��");
		values.put("age", 59);
		db.insert("stutb", null, values);
		values.clear();
		values.put("name", "������");
		values.put("sex", "��");
		values.put("age", 39);
		db.insert("stutb", null, values);
		values.clear();
		values.put("name", "������");
		values.put("sex", "��");
		values.put("age", 29);
		db.insert("stutb", null, values);
		values.clear();
		values.put("sex", "Ů");
		db.update("stutb", values, "_id>?", new String[]{"3"});//��ȫ��id>3���˵��Ա�ĳ�Ů
		db.delete("stutb", "name like ?", new String[]{"%��%"});//ɾ�����������д��з����
		Cursor c = db.query("stutb", null, "_id>?", new String[]{"0"}, null, null, "name");
		if (c!=null) {
			String [] columns= c.getColumnNames();
			while (c.moveToNext()) {
				for (String columnName : columns) {
					Log.i("info", c.getString(c.getColumnIndex(columnName)));
				}
			}
			c.close();
		}
		db.close();
	}

}
