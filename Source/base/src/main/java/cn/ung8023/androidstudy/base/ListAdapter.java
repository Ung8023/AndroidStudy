package cn.ung8023.androidstudy.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author feilang-liuyansong
 * @date 2018/3/16 09:02
 * @description
 */

public class ListAdapter<Data> extends BaseAdapter {

    private List<Data> mData;

    private ListAdapterBind<Data> listAdapterBind;

    public ListAdapter(List<Data> data, ListAdapterBind<Data> listAdapterBind) {
        this.mData = data;
        this.listAdapterBind = listAdapterBind;
    }

    public void setData(List<Data> data) {
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = onCreateViewHolder(parent, listAdapterBind.getLayoutResId(position));
        }else {
            viewHolder = (ListItemViewHolder) convertView.getTag();
            if (viewHolder.getItemViewType() != listAdapterBind.getLayoutResId(position)) {
                viewHolder = onCreateViewHolder(parent, listAdapterBind.getLayoutResId(position));
            }
        }
        convertView = viewHolder.itemView;
        convertView.setTag(viewHolder);
        listAdapterBind.bindData(viewHolder, mData.get(position), position);

        return convertView;
    }

    protected ListItemViewHolder onCreateViewHolder(ViewGroup parent, int itemType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(itemType, parent, false);
        ListItemViewHolder viewHolder = new ListItemViewHolder(inflate);
        viewHolder.setItemViewType(itemType);
        return viewHolder;
    }

}
