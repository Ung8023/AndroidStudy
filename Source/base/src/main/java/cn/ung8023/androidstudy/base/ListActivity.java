package cn.ung8023.androidstudy.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.R;

public abstract class ListActivity<Data> extends AppCompatActivity {

    protected ListView listView;
    protected List<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
        initData();
    }

    protected void initView() {
        listView = findViewById(R.id.listView);
    }

    protected abstract List<Data> getData();

    protected void initData() {

        data = getData();
        ListAdapter<Data> listAdapter = new ListAdapter<>(data, new ListAdapterBind<Data>() {
            @Override
            public int getLayoutResId(int position) {
                return android.R.layout.simple_list_item_1;
            }

            @Override
            public void bindData(ListItemViewHolder viewHolder, Data data, int position) {
                ListActivity.this.bindData(viewHolder, data, position);
            }
        });
        listView.setAdapter(listAdapter);
    }

    protected abstract void bindData(ListItemViewHolder viewHolder, Data data, int position);
}
