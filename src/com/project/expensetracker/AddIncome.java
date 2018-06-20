package com.project.expensetracker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddIncome extends Activity {
	EditText amt;
	private int year;
	private int month;
	private int day;
	private TextView incDate;
	private Button btn;
	Button cal;
    ImageButton imgbtn; 
    Intent openCal;
    Spinner spnPay;
    Spinner spnCat;
	static final int DATE_DIALOG_ID = 100;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_income);
		setCurrentDate();
		addButtonListener();
		amt= (EditText)findViewById(R.id.editIncAmt); 
		//setting Payment Spinner
	    spnPay = (Spinner)findViewById(R.id.spnIncPay);
	    ArrayAdapter<CharSequence> arPay = ArrayAdapter.createFromResource(this,R.array.frequency,R.layout.my_spin);
	    spnPay.setAdapter(arPay);
	    //setting Category Spinner
	    spnCat =(Spinner)findViewById(R.id.spnIncCatg);
	    ArrayAdapter<CharSequence> arCat = ArrayAdapter.createFromResource(this,R.array.IncomeCategory,R.layout.my_spin);
	    spnCat.setAdapter(arCat);
		imgbtn =(ImageButton)findViewById(R.id.btnIncCam);       // for camera
	    cal = (Button)findViewById(R.id.btnIncAmt);           //Calculator button
		cal.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
	    openCal = new Intent("com.project.expensetracker.CALCULATOR");
	    startActivityForResult(openCal,0); 
	    }
				 
		 });
		 imgbtn.setOnClickListener(new OnClickListener() {
	         @Override
	         public void onClick(View v) {
	            open();
	         }
	      });
		// Checking camera availability
			if (!isDeviceSupportCamera()) {
				Toast.makeText(getApplicationContext(),
						"Sorry! Your device doesn't support camera",
						Toast.LENGTH_LONG).show();
				// will close the app if the device does't have camera
				finish();
			}
	}
	
	public void setCurrentDate() {
		 
		incDate = (TextView) findViewById(R.id.editIncdate);
		final Calendar calendar = Calendar.getInstance();
		
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
 
		// set current date into textview
		incDate.setText(new StringBuilder()
			// Month is 0 based, so you have to add 1
			.append(month + 1).append("-")
			.append(day).append("-")
			.append(year).append(" "));
 
	
 
	}
	
	//Date picker method
	public void addButtonListener() {
		 
		btn= (Button) findViewById(R.id.btnIncDate);
		
		btn.setOnClickListener(new OnClickListener() {
 
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
 
				showDialog(DATE_DIALOG_ID);
 
			}
 
		});
 
	}
	@Override
	protected Dialog onCreateDialog(int id) {
		
		switch (id) {
		case DATE_DIALOG_ID:
		   // set date picker as current date
		   return new DatePickerDialog(this, datePickerListener, year, month,day);
		}
		return null;
	}
 
	
	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		 
		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
 
			// set selected date into Text View
			incDate.setText(new StringBuilder().append(month + 1)
			   .append("-").append(day).append("-").append(year).append(" "));
 
			
 
		}
	};
	
	// method for linking camera api
	 public void open(){
	      Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	      startActivityForResult(intent,1);
	   }
	 /**
		 * Checking device has camera hardware or not
		 * */
		private boolean isDeviceSupportCamera() {
			if (getApplicationContext().getPackageManager().hasSystemFeature(
					PackageManager.FEATURE_CAMERA)) {
				// this device has a camera
				return true;
			} else {
				// no camera on this device
				return false;
			}
		}
	   @Override
	   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	      // TODO Auto-generated method stub
		
	      super.onActivityResult(requestCode, resultCode, data);
	      
	  		if (requestCode == 1) 
	  		 {
	  			if (resultCode == RESULT_OK) 
	  			 {
	  				// successfully captured the image
	  				// display it in image view
	  				 Bitmap bp = (Bitmap) data.getExtras().get("data");
	  			      imgbtn.setImageBitmap(bp);
	  			 }
	  			else 
	  			 {
	  				// failed to capture image
	  				Toast.makeText(getApplicationContext(),
	  						" Failed to capture image", Toast.LENGTH_SHORT)
	  						.show();
	    	     }
	  		 }
	  		else
	  		{
	  			if(resultCode==RESULT_OK)
	  			{
	  				String amount = data.getStringExtra("AMOUNT");
	  				amt.setText(amount);
	  			}
	  		}
	  		}
	      }

	
	   



