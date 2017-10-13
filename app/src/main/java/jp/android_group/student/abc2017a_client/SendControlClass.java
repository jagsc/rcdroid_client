package jp.android_group.student.abc2017a_client;

import android.os.AsyncTask;
import android.os.Handler;

import java.util.Arrays;

/**
 * Created by hayatokimura on 2017/10/14.
 */

public class SendControlClass extends AsyncTask<Void, Void, Object> {

    private Handler mHandler = null;
    private JoyStickClass js = null;
    private Runnable mR;

    SendControlClass(Handler handler,JoyStickClass js,Runnable r){
        this.mHandler = handler;
        this.js = js;
        this.mR = r;
    }

    @Override
    protected Object doInBackground(Void... params) {

        Object obj = Arrays.asList(getSignal(js.getX()),getSignal(-js.getY())); // 送信内容
        String address = "192.168.43.104";//"192.168.0.29"; // 受信側端末の実際のアドレスに書き換える
        int port = 12345;
        UDPObjectTransfer.send(obj,address,port);

        return obj;
    }

    @Override
    protected void onPostExecute(Object result) {
        mHandler.postDelayed(mR,100);
    }

    private double getSignal(int inputValue){
        if(inputValue<-150){
            inputValue = -150;
        }else if(150<inputValue){
            inputValue = 150;
        }

        return (100.0/150.0)*inputValue;
    }
}
