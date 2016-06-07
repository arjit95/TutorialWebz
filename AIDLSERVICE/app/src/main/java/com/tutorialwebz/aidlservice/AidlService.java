package com.tutorialwebz.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;


public class AidlService extends Service {
    public AidlService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
    private final IAidlInterface.Stub mBinder = new IAidlInterface.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            // TODO Auto-generated method stub
            return (num1 + num2);
        }
    };
}
