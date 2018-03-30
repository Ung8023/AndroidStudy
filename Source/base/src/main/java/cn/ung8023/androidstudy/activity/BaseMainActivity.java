package cn.ung8023.androidstudy.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import cn.ung8023.androidstudy.base.ListActivity;
import cn.ung8023.androidstudy.base.ListItemViewHolder;
import cn.ung8023.androidstudy.activity.ActivityEntity;

/**
 * @author feilang-liuyansong
 * @date 2018/3/29 15:42
 * @description
 */

public abstract class BaseMainActivity extends ListActivity<ActivityEntity> {

    @Override
    protected void bindData(ListItemViewHolder viewHolder, final ActivityEntity activityEntity, int position) {
        TextView textView = viewHolder.itemView.findViewById(android.R.id.text1);
        textView.setText(activityEntity.getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), activityEntity.getTargetClass()));
            }
        });
    }

}
