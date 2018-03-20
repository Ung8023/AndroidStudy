package cn.ung8023.androidstudy.base;

import android.view.View;

/**
 * @author feilang-liuyansong
 * @date 2018/3/16 09:08
 * @description
 */

public class ListItemViewHolder {
    public View itemView;
    private int itemViewType;

    public ListItemViewHolder(View itemView) {
        this.itemView = itemView;
    }

    public int getItemViewType() {
        return itemViewType;
    }

    public void setItemViewType(int itemViewType) {
        this.itemViewType = itemViewType;
    }
}
