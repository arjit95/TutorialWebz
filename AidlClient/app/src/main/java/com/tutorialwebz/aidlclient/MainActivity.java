package com.tutorialwebz.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorialwebz.aidlservice.IAidlInterface;
public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    Button submit;
    IAidlInterface mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindToService();
        edit1= (EditText) findViewById(R.id.num1);
        edit2 = (EditText) findViewById(R.id.num2);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1=edit1.getText().toString();
                String num2=edit2.getText().toString();
                if(mService!=null)
                    try{
                        Toast.makeText(getApplicationContext(),
                                "Sum is:"+mService.add(Integer.parseInt(num1),Integer.parseInt(num2)),
                        Toast.LENGTH_SHORT).show();
                    }
                    catch(RemoteException e){
                        e.printStackTrace();
                    }
            }
        });
    }
    private void bindToService(){
      Intent i = new Intent(IAidlInterface.class.getName());
      i.setAction("aidl.service");
      i.setPackage("com.tutorialwebz.aidlservice");
      bindService(i,mConnection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
           mService= IAidlInterface.Stub.asInterface(iBinder);
           Toast.makeText(getApplicationContext(),
                    "Service Connected", Toast.LENGTH_SHORT)
                    .show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mService=null;
        }
    };
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unbindService(mConnection);
    }
}
