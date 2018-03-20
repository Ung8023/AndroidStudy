package cn.ung8023.mvvm.data.observableclass;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.ung8023.mvvm.BR;
import cn.ung8023.mvvm.R;
import cn.ung8023.mvvm.databinding.ActivityObservableClassBinding;

public class ObservableClassActivity extends AppCompatActivity {

    ActivityObservableClassBinding dataBinding;
    UserEntity userEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_observable_class);
        userEntity =
                new UserEntity("http://img5.imgtn.bdimg.com/it/u=1893461451,2619342480&fm=27&gp=0.jpg", "AAAAAAAAAAAAAAAAAAA", "aaaaaaaaaaaaaaaaaaaa\naaaaaaaaaaaaaaaaaa");
        dataBinding.setVariable(BR.user, userEntity);

    }

    public void setImage(View view) {
        userEntity.setImageUrl("http://img1.imgtn.bdimg.com/it/u=1794894692,1423685501&fm=27&gp=0.jpg");
    }
    public void setTitle(View view) {
        userEntity.setTitle("BBBBBBBBBBBBBBBBBBBBBBBBBB");
    }
    public void setDes(View view) {
        userEntity.setDes("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
    }
    public void setAll(View view) {
        userEntity.setImageUrl("http://img1.imgtn.bdimg.com/it/u=1794894692,1423685501&fm=27&gp=0.jpg");
        userEntity.setTitle("BBBBBBBBBBBBBBBBBBBBBBBBB");
        userEntity.setDes("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
    }
    public void reset(View view) {
        userEntity.setImageUrl("http://img5.imgtn.bdimg.com/it/u=1893461451,2619342480&fm=27&gp=0.jpg");
        userEntity.setTitle("AAAAAAAAAAAAAAAAAAA");
        userEntity.setDes("aaaaaaaaaaaaaaaaaaaa\naaaaaaaaaaaaaaaaaa");
    }
}
