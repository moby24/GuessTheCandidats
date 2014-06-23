package com.moby.vybori2014;

//Игровая активность
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;

import com.moby.vybori2014.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity implements OnClickListener {

	private static final int CANDIDATS = 24;

	ImageView iv;
	Button variantA;
	Button variantB;
	Button variantC;
	Button variantD;
	TableRow tableRow1;
	TableRow tableRow2;
	int count;
	int score;
	Random random;
	double random2;
	int r_foto;
	Context context;
	Activity a;
	TextView myScore;
	TextView hiScore;
	EditText editText;
	String namePlayer;
	// DataBase
	DatabaseHelper dbHelper;
	SQLiteDatabase sdb;
	// Массив имен изображенй из Assets
	String arr[];
	// Массив имен для названий кнопок
	String arrNameButtons[];

	ContentValues newValues;

	String KEY_SCORE = "score";
	String KEY_VARIANT_A = "varianta";
	String KEY_VARIANT_B = "variantb";
	String KEY_VARIANT_C = "variantc";
	String KEY_VARIANT_D = "variantd";
	String KEY_IMAGE = "image";

	GameLogic mGameLogic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_main);
		// Инициализация всех View
		iv = (ImageView) findViewById(R.id.imageView1);
		variantA = (Button) findViewById(R.id.button1);
		variantA.setOnClickListener(this);
		variantB = (Button) findViewById(R.id.button2);
		variantB.setOnClickListener(this);
		variantC = (Button) findViewById(R.id.button3);
		variantC.setOnClickListener(this);
		variantD = (Button) findViewById(R.id.button4);
		variantD.setOnClickListener(this);
		myScore = (TextView) findViewById(R.id.myScore);

		tableRow1 = (TableRow) findViewById(R.id.tableRow1);
		tableRow2 = (TableRow) findViewById(R.id.tableRow2);
		editText = new EditText(this);

		// Загружаем на начальный экран картинку и значение кнопок
		a = this;
		count = 0;
		mGameLogic = new GameLogic(a, iv, variantA, variantB, variantC,
				variantD, count);
		myScore.setText(count + 1 + " из 24");

		dbHelper = new DatabaseHelper(this, "mydatabase.db", null, 1);

		sdb = dbHelper.getWritableDatabase();
	}

	private void alertDialog() {
		if (count == 23) {

			AlertDialog.Builder result = new Builder(a);
			result.setTitle("Вы победили!!!");
			result.setView(editText);
			result.setMessage("Введите ваше имя избиратель:")
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {

								private Intent intent;

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									namePlayer = editText.getText().toString();
									intent = new Intent(a, TableRecord.class);
									newValues = new ContentValues();

									newValues.put(dbHelper.SCORE_NAME_COLUMN,
											namePlayer);

									// Вставляем данные в базу
									sdb.insert("game", null, newValues);

									startActivity(intent);

								}
							});

			result.show();
			// count = -1;

		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			alertDialog();

			if (mGameLogic.arrNameButtons[count].equals(variantA.getText()) == true) {
				extracted();
			} else if (mGameLogic.arrNameButtons[count].equals(variantA
					.getText()) == false) {
				exitActivity();
			}
			break;
		case R.id.button2:
			alertDialog();
			if (mGameLogic.arrNameButtons[count].equals(variantB.getText()) == true) {
				extracted();
			} else if (mGameLogic.arrNameButtons[count].equals(variantB
					.getText()) == false) {
				exitActivity();
			}

			break;
		case R.id.button3:
			alertDialog();
			if (mGameLogic.arrNameButtons[count].equals(variantC.getText()) == true) {
				extracted();
			} else if (mGameLogic.arrNameButtons[count].equals(variantC
					.getText()) == false) {
				exitActivity();
			}

			break;
		case R.id.button4:

			alertDialog();
			if (mGameLogic.arrNameButtons[count].equals(variantD.getText()) == true) {
				extracted();
			} else if (mGameLogic.arrNameButtons[count].equals(variantD
					.getText()) == false) {
				exitActivity();
			}
			break;
		}
	}

	private void extracted() {
		if (count != 23) {
			count++;
			mGameLogic = new GameLogic(a, iv, variantA, variantB, variantC,
					variantD, count);
			myScore.setText(count + 1 + " из 24");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// занесем активность правил
		menu.add("Правила");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(GameActivity.this, Rules.class);
		startActivity(intent);
		return true;
	}

	@SuppressLint("ShowToast")
	public void exitActivity() {
		Toast.makeText(a, "Вы проиграли!", Toast.LENGTH_LONG).show();
		this.finish();
	}

}
