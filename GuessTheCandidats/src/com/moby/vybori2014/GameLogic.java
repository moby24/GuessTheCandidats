package com.moby.vybori2014;

import java.io.IOException;
import java.io.InputStream;
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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameLogic extends Activity {

	public static final int CANDIDATS = 24;
	ImageView iv;
	TextView myScore;
	TextView hiScore;
	EditText editText;
	int record;
	Random random;
	double random2;
	double diapazon;
	// Массив имен изображенй из Assets
	String arr[];
	String arrNameButtons[];

	int r_name;
	int r_name2;
	int r_name3;
	int r_name4;
	int r_foto;

	String namePlayer;
	int count;
	int myhiscore;
	int score;
	Context context;
	Activity activity;
	Drawable d;
	private InputStream ims;
	private double diapazonLeft;
	private double diapazonRight;

	// Метод который заносит рандомно имена на кнопки
	public GameLogic(Activity a, ImageView iv, Button variantA,
			Button variantB, Button variantC, Button variantD, int r_foto) {
		arrNameButtons = a.getResources().getStringArray(R.array.arrButton);
		arr = a.getResources().getStringArray(R.array.arrPic);

		random = new Random();
		diapazonLeft = Math.random() * (r_foto - 1);
		diapazonRight = (Math.random()* (CANDIDATS-r_foto)+r_foto);

		// правильный вариант кнопки меняется произвольно
		int chouse = random.nextInt(4);
		switch (chouse) {
		case 0:
			variantA.setText(arrNameButtons[r_foto]);
			r_name2 = random.nextInt(CANDIDATS);
			variantB.setText(arrNameButtons[(int) diapazonLeft]);
			r_name3 = random.nextInt(CANDIDATS);
			variantC.setText(arrNameButtons[(int) diapazonRight]);
			r_name4 = random.nextInt(CANDIDATS);
			variantD.setText(arrNameButtons[r_name4]);
			break;
		case 1:
			variantB.setText(arrNameButtons[r_foto]);
			r_name = random.nextInt(CANDIDATS);
			variantA.setText(arrNameButtons[r_name]);
			r_name3 = random.nextInt(CANDIDATS);
			variantC.setText(arrNameButtons[r_name3]);
			r_name4 = random.nextInt(CANDIDATS);
			variantD.setText(arrNameButtons[r_name4]);
			break;
		case 2:
			variantC.setText(arrNameButtons[r_foto]);
			r_name = random.nextInt(CANDIDATS);
			variantA.setText(arrNameButtons[r_name]);
			r_name2 = random.nextInt(CANDIDATS);
			variantB.setText(arrNameButtons[r_name2]);
			r_name4 = random.nextInt(CANDIDATS);
			variantD.setText(arrNameButtons[r_name4]);
			break;
		case 3:
			variantD.setText(arrNameButtons[r_foto]);
			r_name = random.nextInt(CANDIDATS);
			variantA.setText(arrNameButtons[r_name]);
			r_name2 = random.nextInt(CANDIDATS);
			variantB.setText(arrNameButtons[r_name2]);
			r_name3 = random.nextInt(CANDIDATS);
			variantC.setText(arrNameButtons[r_name3]);
			break;
		}

		try {
			// массив изображений
			ims = a.getAssets().open(arr[r_foto]);
			d = Drawable.createFromStream(ims, null);
			iv.setImageDrawable(d);
		} catch (IOException ex) {
			return;
		}
		return;
	}

}