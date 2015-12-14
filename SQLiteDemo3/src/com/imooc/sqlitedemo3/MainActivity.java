package com.imooc.sqlitedemo3;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DBOpenHelper helper =	new DBOpenHelper(MainActivity.this, "stu.db");
//		helper.getReadableDatabase();//获取一个只读的数据库 只能查询 不能写入 不能更新
		SQLiteDatabase db = helper.getWritableDatabase();
//		db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
		Cursor c = db.rawQuery("select * from stutb", null);
		if (c!=null) {
			String [] cols = c.getColumnNames();
			while (c.moveToNext()) {
				for (String ColumnName : cols) {
					Log.i("info", ColumnName+":"+c.getString(c.getColumnIndex(ColumnName)));
				}
			}
			c.close();
		}
		db.close();
	}


}
