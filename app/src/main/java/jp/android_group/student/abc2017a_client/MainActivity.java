package jp.android_group.student.abc2017a_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
	private int speed=0;

	private void sendAccelSignal()
	{


	}

	private void sendBackSignal()
	{


	}

	private void sendHandle()
	{


	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button accelBtn=(Button)findViewById(R.id.AccelButton);
		Button backBtn=(Button)findViewById(R.id.BackButton);
		ToggleButton leftBtn=(ToggleButton)findViewById(R.id.LeftButton);
		ToggleButton rightBtn=(ToggleButton)findViewById(R.id.RightButton);
		SeekBar speedBar=(SeekBar) findViewById(R.id.SpeedBar);

		accelBtn.setOnClickListener(this);
		backBtn.setOnClickListener(this);
		leftBtn.setOnClickListener(this);
		rightBtn.setOnClickListener(this);

		accelBtn.setOnLongClickListener(this);
		backBtn.setOnLongClickListener(this);


		speedBar.setOnTouchListener(this);



	}
	public void onClick(View view){
		switch (view.getId()){
			case R.id.AccelButton:

				break;
			case R.id.BackButton:

				break;
			case R.id.LeftButton:

				break;
			case R.id.RightButton:

				break;

		}
	}
	public boolean onLongClick(View view){
		switch (view.getId()){
			case R.id.AccelButton:

				return true;
			case R.id.BackButton:

				return true;
			default:
				return false;
		}
	}

	public boolean onTouch(View view, MotionEvent motionEvent){
		switch(view.getId()){
			case R.id.SpeedBar:

				return false;
			default:
				return false;
		}
	}

}