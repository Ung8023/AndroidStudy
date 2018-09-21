package com.ung8023.androidbase.process.aidl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

import java.util.List;

public interface IDefineBookManager extends IInterface{
    static final String DESCRIPTOR = "com.ung8023.androidbase.process.aidl.IDefineBookManager";

    static final int TRANSACTION_getBookList = IBinder.FIRST_CALL_TRANSACTION;
    static final int TRANSACTION_addBook = IBinder.FIRST_CALL_TRANSACTION + 1;

    public List<Book> getBookList() throws RemoteException;
    public void addBook(Book book) throws RemoteException;
}
