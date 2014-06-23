package com.moby.vybori2014;

import org.w3c.dom.Text;

import com.moby.vybori2014.R;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TableRecord extends Activity {
	ScrollView sv;
	LinearLayout ll;
	TextView res;
	Context context;
	private int pixels = 50;

	DatabaseHelper dbHelper;
	SQLiteDatabase sdb;
	int last_record;
	private String name;
	private String nameRec;
	private ContentValues newValues;
	GameActivity mGameActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.records);
		context = this;
		sv = (ScrollView) findViewById(R.id.scrollRecord);
		sv.setBackgroundColor(Color.YELLOW);
		ll = (LinearLayout) findViewById(R.id.layoutRecord);

		// заполнение текствью

		databasefill();

	}

	public void databasefill() {

		dbHelper = new DatabaseHelper(this, "mydatabase.db", null, 1);

		sdb = dbHelper.getWritableDatabase();

		Cursor cursor = sdb.query("game",
				new String[] { dbHelper.SCORE_NAME_COLUMN }, null, null, null,
				null, null);

		for (int i = 0; i < cursor.getCount(); i++) {

			cursor.moveToPosition(i);
			nameRec = cursor.getString(cursor
					.getColumnIndex(dbHelper.SCORE_NAME_COLUMN));
			res = new TextView(context);
			res.setGravity(Gravity.CENTER);
			res.setBackgroundColor(Color.BLUE);
			res.setTextSize((float) 25.0f);
			res.setText(nameRec);
			ll.addView(res);
		}

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent a = new Intent(this, FirstActivity.class);
		a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(a);

	}

}
