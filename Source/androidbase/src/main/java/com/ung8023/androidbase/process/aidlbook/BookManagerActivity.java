package com.ung8023.androidbase.process.aidlbook;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ung8023.androidbase.R;
import com.ung8023.androidbase.process.aidl.Book;
import com.ung8023.androidbase.process.aidl.IBookManager;
import com.ung8023.androidbase.process.aidl.IOnNewBookArrivedListener;

import java.util.List;

public class BookManagerActivity extends AppCompatActivity {

    private static final String TAG = "BookManagerActivity";
    private static final int MESSGAE_NEW_BOOK_ARRIVED = 1;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSGAE_NEW_BOOK_ARRIVED:
                    Log.d(TAG, "receive new book : " + msg.obj);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private IOnNewBookArrivedListener mIOnNewBookArrivedListener = new IOnNewBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {
            mHandler.obtainMessage(MESSGAE_NEW_BOOK_ARRIVED, newBook).sendToTarget();
        }
    };

    private IBookManager mBookManager;

    private TextView tv;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBookManager = IBookManager.Stub.asInterface(service);
            try {
                List<Book> bookList = mBookManager.getBookList();
                Log.w(TAG, "query book list, list type" + bookList.getClass().getCanonicalName());
                Log.w(TAG, "query book list: " + bookList.toString());
                tv.setText(bookList.toString());

                Book newBook = new Book(3, "Java编程思想");
                mBookManager.addBook(newBook);
                List<Book> bookList1 = mBookManager.getBookList();
                Log.w(TAG, "query book list: " + bookList1.toString());
                mBookManager.registerListener(mIOnNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_manager);

        tv = findViewById(R.id.tv);
    }

    public void getBookList(View view) {
        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBookManager != null
                && mBookManager.asBinder().isBinderAlive()) {
            try {
                Log.w(TAG, "unregister listener:" + mIOnNewBookArrivedListener);
                mBookManager.unregisterListener(mIOnNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        unbindService(mConnection);
    }
}
