package cn.ung8023.mvvm.data.observableclass;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import cn.ung8023.mvvm.BR;

/**
 * @author feilang-liuyansong
 * @date 2018/2/1 16:32
 * @description
 */

public class UserEntity extends BaseObservable{

    private String imageUrl;
    private String title;
    private String des;

    public UserEntity(String imageUrl, String title, String des) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.des = des;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
        notifyPropertyChanged(BR.des);
    }
}
