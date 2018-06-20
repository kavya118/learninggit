package com.project.expensetracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class InterestCalculator extends Activity {

	Spinner spnComp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		spnComp =(Spinner)findViewById(R.id.spnComp);
	    ArrayAdapter<CharSequence> arComp = ArrayAdapter.createFromResource(this,R.array.Compounding,R.layout.my_spin);
	    spnComp.setAdapter(arComp);
	}
	

}
