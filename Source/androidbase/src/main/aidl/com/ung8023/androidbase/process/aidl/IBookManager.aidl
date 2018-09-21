package com.ung8023.androidbase.process.aidl;
import com.ung8023.androidbase.process.aidl.Book;
import com.ung8023.androidbase.process.aidl.IOnNewBookArrivedListener;
/*
 AIDL 支持的数据类型
 1. 基本数据类型(int 、long、char、boolean、double)
 2. String CharSequence;
 3. List：只支持ArrayList，里面每个元素必须能够被AIDL支持
 4. Map: 只支持HashMap，里面的每个元素都必须被AIDL支持，包括key和value
 5. Parcelable： 所有实现了Parcelable接口的对象
 6. AIDL：所有的AIDL接口本身也可以在AIDL文件中声明

 AIDL除了基本数据类型，其他类型的参数必须标上方向：in、out或者inout
 AIDL接口中只支持方法，不支持声明静态常量。
*/
interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
    void registerListener(IOnNewBookArrivedListener listener);
    void unregisterListener(IOnNewBookArrivedListener listener);
}