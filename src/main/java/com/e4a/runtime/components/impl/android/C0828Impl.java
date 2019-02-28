package com.e4a.runtime.components.impl.android;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0827;

/* renamed from: com.e4a.runtime.components.impl.android.表格布局Impl */
public class C0828Impl extends LayoutImpl implements C0827 {
    private int columns;
    private boolean fixed;
    private int rows;

    C0828Impl(ViewComponentContainer container) {
        super(new TableLayout(mainActivity.getContext()), container);
        ((TableLayout) getLayoutManager()).setStretchAllColumns(true);
    }

    /* renamed from: 列数 */
    public void mo1473(int newColumns) {
        this.columns = newColumns;
    }

    /* renamed from: 行数 */
    public void mo1474(int newRows) {
        this.rows = newRows;
    }

    public void addComponent(ViewComponent component) {
    }

    void placeComponent(ViewComponent component) {
        ensureTableInitialized();
        int column = component.mo766();
        int row = component.mo800();
        if (column >= 0 && column < this.columns && row >= 0 && row < this.rows) {
            ((TableRow) getLayoutManager().getChildAt(row)).addView(component.getView(), new LayoutParams(column));
        }
    }

    private void ensureTableInitialized() {
        if (!this.fixed) {
            this.fixed = true;
            ViewGroup layoutManager = getLayoutManager();
            Context context = layoutManager.getContext();
            for (int row = 0; row < this.rows; row++) {
                layoutManager.addView(new TableRow(context), new TableLayout.LayoutParams(-2, -2));
            }
        }
    }
}
