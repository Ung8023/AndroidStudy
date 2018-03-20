package cn.ung8023.mvvm.data.observablefield;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableByte;
import android.databinding.ObservableChar;
import android.databinding.ObservableDouble;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;
import android.databinding.ObservableInt;
import android.databinding.ObservableLong;
import android.databinding.ObservableShort;

/**
 * @author feilang-liuyansong
 * @date 2018/3/16 11:57
 * @description
 */

public class UserInfo {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();

    public final ObservableBoolean isSuperMan = new ObservableBoolean();
    public final ObservableByte bookNum = new ObservableByte();
    public final ObservableShort bookFans = new ObservableShort();
    public final ObservableInt age = new ObservableInt();
    public final ObservableLong money = new ObservableLong();
    public final ObservableChar sex = new ObservableChar();
    public final ObservableFloat bankMoney = new ObservableFloat();
    public final ObservableDouble dkMoney = new ObservableDouble();

    public final ObservableArrayList<String> children = new ObservableArrayList<>();

}
