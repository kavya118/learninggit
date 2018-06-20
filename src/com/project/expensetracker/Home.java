package com.project.expensetracker;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Home extends Fragment implements OnClickListener {

	public Home() {
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.home, container, false);
		Button btnInc = (Button) rootView.findViewById(R.id.Income);
		Button btnExp = (Button) rootView.findViewById(R.id.Expense);
		Button btnSum = (Button) rootView.findViewById(R.id.Summary);
		Button btnBud = (Button) rootView.findViewById(R.id.Budget);
		Button btnCal = (Button) rootView.findViewById(R.id.Calender);
		Button btnChrt = (Button) rootView.findViewById(R.id.Chart);
		btnInc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openIncome = new Intent(
						"com.project.expensetracker.ADDINCOME");
				startActivity(openIncome);
			}

		});
		btnChrt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openIncome = new Intent(
						"com.project.expensetracker.CHART");
				startActivity(openIncome);
			}

		});
		btnExp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openIncome = new Intent(
						"com.project.expensetracker.ADDEXPENSE");
				startActivity(openIncome);
			}

		});
		btnSum.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openIncome = new Intent(
						"com.project.expensetracker.SUMMARY");
				startActivity(openIncome);
			}

		});
		btnBud.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openIncome = new Intent(
						"com.project.expensetracker.BUDGET");
				startActivity(openIncome);
			}

		});
		btnCal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openIncome = new Intent(
						"com.project.expensetracker.CALENDER");
				startActivity(openIncome);
			}

		});

		return rootView;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
