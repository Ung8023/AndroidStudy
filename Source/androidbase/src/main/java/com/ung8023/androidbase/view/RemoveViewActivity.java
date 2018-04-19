package com.ung8023.androidbase.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;

import com.ung8023.androidbase.R;
import com.ung8023.androidbase.utils.ViewUtils;

/***

 1. 移除View时，能够移除直接子级View
 2. 不能移除子级以下的View
 3. 可以通获取子级的直接父级，再通过父级移除View

 */
public class RemoveViewActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_view);

        linearLayout = findViewById(R.id.parent);
    }

    public void removeChild(View view) {
        linearLayout.removeView(findViewById(R.id.son));
    }

    public void removeGrandSon(View view) {
        //不能直接移除
//        linearLayout.removeView(findViewById(R.id.grand_son));

        //通过获取父级View来移除
        View findView = findViewById(R.id.grand_son);
        if (findView == null) {
            return;
        }

        ViewUtils.removeSelf(findView);

    }

    public void removeGrandGrandSon(View view) {
        //不能直接移除
//        linearLayout.removeView(findViewById(R.id.grand_grand_son));
        ViewUtils.removeSelf(linearLayout, R.id.grand_grand_son);
    }

}
