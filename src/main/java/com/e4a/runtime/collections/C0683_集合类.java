package com.e4a.runtime.collections;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.variants.Variant;
import java.util.ArrayList;
import java.util.Collections;

@SimpleObject
/* renamed from: com.e4a.runtime.collections.集合 */
public final class C0683_集合类 {
    private ArrayList<Variant> list = new ArrayList();

    @SimpleFunction
    /* renamed from: 清空 */
    public void m5459_清空() {
        this.list.clear();
    }

    @SimpleFunction
    /* renamed from: 加入项目 */
    public void m5454_集合add元素(Variant item) {
        this.list.add(item);
    }

    @SimpleFunction
    /* renamed from: 插入项目 */
    public void m5458(int index, Variant item) {
        this.list.add(index, item);
    }

    @SimpleFunction
    /* renamed from: 取项目 */
    public Variant m5455_集合get元素(int index) {
        try {
            return (Variant) this.list.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @SimpleFunction
    /* renamed from: 置项目 */
    public void m5460(int index, Variant item) {
        if (index < this.list.size()) {
            this.list.set(index, item);
        }
    }

    @SimpleFunction
    /* renamed from: 取项目总数 */
    public int m5456_取项目总数() {
        return this.list.size();
    }

    @SimpleFunction
    /* renamed from: 删除项目 */
    public void m5453(int index) {
        this.list.remove(index);
    }

    @SimpleFunction
    /* renamed from: 打乱顺序 */
    public void m5457() {
        Collections.shuffle(this.list);
    }
}
