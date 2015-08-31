package com.bontouch.databindings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.old_style_example).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				final Intent intent = new Intent(MainActivity.this, OldActivity.class);
				startActivity(intent);
			}
		});
		findViewById(R.id.databindings_example).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				final Intent intent = new Intent(MainActivity.this, DataBindingsActivity.class);
				startActivity(intent);
			}
		});
	}
}
