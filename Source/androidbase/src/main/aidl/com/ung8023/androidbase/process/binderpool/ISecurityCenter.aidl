// ISecurityCenter.aidl
package com.ung8023.androidbase.process.binderpool;

// Declare any non-default types here with import statements

interface ISecurityCenter {
    String encrypt(String content);
    String decrypt(String password);
}
