package com.wzq.listrowview;

import android.content.Context;
import android.support.v17.leanback.widget.VerticalGridView;
import android.util.AttributeSet;

/**
 * Created by wzq on 2018/3/23.
 */

public class ListRowView extends VerticalGridView {
    public ListRowView(Context context) {
        super(context);
    }

    public ListRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private BasePresenter presenter;

    public void setPresenter(BasePresenter presenter){
        this.presenter = presenter;
        setAdapter(new ListAdapter(presenter.createRow()));
    }
}
