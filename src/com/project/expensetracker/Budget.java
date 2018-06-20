package com.project.expensetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Budget extends Activity {
	private Button backButton, okButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_income);
		backButton = (Button) findViewById(R.id.btnCncl);
		okButton = (Button) findViewById(R.id.btnok);

	}

}
