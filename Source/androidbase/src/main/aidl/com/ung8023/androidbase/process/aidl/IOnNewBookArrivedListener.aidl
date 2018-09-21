// IOnNewBookArrivedListener.aidl
package com.ung8023.androidbase.process.aidl;
import com.ung8023.androidbase.process.aidl.Book;

// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book newBook);
}
