package jp.android_group.student.abc2017a_client;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.SeekBar;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements
		View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
	private int speed = 0;

	private void sendAccelSignal()
	{
		int speed = 10;
		Object obj = Arrays.asList("speed"); // 送信内容
		String address = "192.168.1.5"; // 受信側端末の実際のアドレスに書き換える
		int port = 12345;                // 受信側と揃える
		UDPObjectTransfer.send(obj, address, port);
	}

	private void sendBackSignal()
	{
		int speed = -5;
		Object obj = Arrays.asList("speed");
		String address = "192.168.1.5";
		int port = 12345;
		UDPObjectTransfer.send(obj, address, port);
	}

	private void sendHandle()
	{
		/*	未実装:右左旋回時の挙動とそれに伴うコード
		* 	なんか識別的なの送ってモータ側で制御出来たら神
		* 	お願いします*/

		//int speed = 5/Math.cos(Math.toRadians(45));	なんかエラーでダメだった
		int speed = 0;	//暫定
		Object obj = Arrays.asList("speed");
		String address = "192.168.1.5";
		int port = 12345;
		UDPObjectTransfer.send(obj, address, port);
	}

	private void sendLongAccel()
	{
		int speed =+ 10;
		Object obj = Arrays.asList("speed");
		String address = "192.168.1.5";
		int port = 12345;
		UDPObjectTransfer.send(obj, address, port);
	}

	private void sendLongBack()
	{
		int speed =- 10;
		Object obj = Arrays.asList("speed");
		String address = "192.168.1.5";
		int port = 12345;
		UDPObjectTransfer.send(obj, address, port);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
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
					sendAccelSignal();
				break;
			case R.id.BackButton:
					sendBackSignal();
				break;
			case R.id.LeftButton:
					sendHandle();
				break;
			case R.id.RightButton:
					sendHandle();
				break;
		}
	}

	public boolean onLongClick(View view){
		switch (view.getId()){
			case R.id.AccelButton:
					sendLongAccel();
				return true;
			case R.id.BackButton:
					sendLongBack();
				return true;
			default:
				return false;
		}
	}

	/*スピード調整用？
	* 改良案浮かばずに保留状態*/
	public boolean onTouch(View view, MotionEvent motionEvent){
		switch(view.getId()){
			case R.id.SpeedBar:

				return false;
			default:
				return false;
		}
	}
}