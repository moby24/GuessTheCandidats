package com.moby.vybori2014;

import com.moby.vybori2014.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FirstActivity extends Activity {
	Button play;
	Button records;
	Button rules;
	ImageView google;
	Activity activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_activity);
		play = (Button) findViewById(R.id.buttonMenu1);
		records = (Button) findViewById(R.id.buttonMenu2);
		rules = (Button) findViewById(R.id.buttonMenu3);
		google = (ImageView) findViewById(R.id.imageViewMenu1);
		activity = this;
		play.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(activity, GameActivity.class);
				startActivity(intent);
			}
		});
		rules.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(activity, Rules.class);
				startActivity(intent);
			}
		});
		records.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(activity, TableRecord.class);
				startActivity(intent);
			}
		});
		google.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent localIntent = new Intent(
						"android.intent.action.VIEW",
						Uri.parse("http://play.google.com/store/apps/details?id=com.moby.vybori2014"));
				startActivity(localIntent);
			}
		});
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add("Поделиться...").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent
						.putExtra(Intent.EXTRA_TEXT,
								"Качай классное приложение http://play.google.com/store/apps/details?id=com.moby.vybori2014");
				sendIntent.setType("text/plain");
				startActivity(sendIntent);
				return true;
			}
		});
		return super.onCreateOptionsMenu(menu);
		
	}

	
	
}
