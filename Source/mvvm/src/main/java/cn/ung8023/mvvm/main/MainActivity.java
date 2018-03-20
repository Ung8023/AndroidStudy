package cn.ung8023.mvvm.main;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.base.ListActivity;
import cn.ung8023.androidstudy.base.ListItemViewHolder;
import cn.ung8023.mvvm.data.observableclass.ObservableClassActivity;
import cn.ung8023.mvvm.data.observablefield.ObservableFieldActivity;

public class MainActivity extends ListActivity<ActivityEntity> {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("ObservableClass", ObservableClassActivity.class));
                add(new ActivityEntity("ObservableFields", ObservableFieldActivity.class));
            }
        };
    }

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
