package cn.ung8023.mvvm.data.observableclass;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author feilang-liuyansong
 * @date 2018/2/1 16:35
 * @description
 */

public class ImageBindAdapter {
    @BindingAdapter("loadImage")
    public static void loadInternetImage(ImageView iv, String imageUrl) {
        Glide.with(iv).load(imageUrl).into(iv);
    }

}
