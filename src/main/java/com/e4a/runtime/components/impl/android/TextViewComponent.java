package com.e4a.runtime.components.impl.android;

import android.widget.TextView;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.TextComponent;
import com.e4a.runtime.components.impl.android.util.TextViewUtil;

public abstract class TextViewComponent extends ViewComponent implements TextComponent {
    private int alpha;
    private int fontTypeface;
    private int justification;
    private int textColor;
    /* renamed from: v */
    private boolean f4283v;

    protected TextViewComponent(ComponentContainer container) {
        super(container);
    }

    /* renamed from: 透明度 */
    public int mo898() {
        return this.alpha;
    }

    /* renamed from: 透明度 */
    public void mo899(int value) {
        this.alpha = value;
        TextView view = (TextView) getView();
        view.getBackground().setAlpha(value);
        view.invalidate();
    }

    /* renamed from: 粗体 */
    public boolean mo897() {
        return TextViewUtil.isFontBold((TextView) getView());
    }

    /* renamed from: 粗体 */
    public void mo896(boolean bold) {
        TextViewUtil.setFontBold((TextView) getView(), bold);
    }

    /* renamed from: 斜体 */
    public boolean mo893() {
        return TextViewUtil.isFontItalic((TextView) getView());
    }

    /* renamed from: 斜体 */
    public void mo892(boolean italic) {
        TextViewUtil.setFontItalic((TextView) getView(), italic);
    }

    public int FontTypeface() {
        return this.fontTypeface;
    }

    public void FontTypeface(int typeface) {
        this.fontTypeface = typeface;
        TextViewUtil.setFontTypeface((TextView) getView(), typeface);
    }

    /* renamed from: 对齐方式 */
    public int mo890() {
        return this.justification;
    }

    /* renamed from: 对齐方式 */
    public void mo891_对齐方式(int newJustification) {
        this.justification = newJustification;
        TextViewUtil.setJustification((TextView) getView(), newJustification);
    }

    /* renamed from: 内容 */
    public String mo886_内容() {
        return TextViewUtil.getText((TextView) getView());
    }

    /* renamed from: 内容 */
    public void mo887_内容(String newtext) {
        TextViewUtil.setText((TextView) getView(), newtext);
    }

    /* renamed from: 标题 */
    public String mo894() {
        return TextViewUtil.getText((TextView) getView());
    }

    /* renamed from: 标题 */
    public void mo895(String newtext) {
        TextViewUtil.setText((TextView) getView(), newtext);
    }

    /* renamed from: 字体颜色 */
    public int mo888() {
        return this.textColor;
    }

    /* renamed from: 字体颜色 */
    public void mo889_字体颜色(int argb) {
        this.textColor = argb;
        TextViewUtil.setTextColor((TextView) getView(), argb);
    }
}
