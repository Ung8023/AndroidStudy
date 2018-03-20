package cn.ung8023.androidstudy.base;

import android.support.annotation.LayoutRes;

/**
 * @author feilang-liuyansong
 * @date 2018/3/16 09:30
 * @description
 */

public interface ListAdapterBind<Data> {
    @LayoutRes int getLayoutResId(int position);
    void bindData(ListItemViewHolder viewHolder, Data data, int position);
}
