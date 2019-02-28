package com.e4a.runtime.collections;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.variants.Variant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SimpleObject
/* renamed from: com.e4a.runtime.collections.哈希表 */
public final class C0682 {
    private Iterator<String> iterator = this.map.keySet().iterator();
    private Map<String, Variant> map = new HashMap();

    @SimpleFunction
    /* renamed from: 清空 */
    public void m5452() {
        this.map.clear();
        this.iterator = this.map.keySet().iterator();
    }

    @SimpleFunction
    /* renamed from: 加入项目 */
    public void m5447(String key, Variant value) {
        this.map.put(key, value);
        this.iterator = this.map.keySet().iterator();
    }

    @SimpleFunction
    /* renamed from: 取项目 */
    public Variant m5448(String key) {
        return (Variant) this.map.get(key);
    }

    @SimpleFunction
    /* renamed from: 是否有下一个 */
    public boolean m5451() {
        return this.iterator.hasNext();
    }

    @SimpleFunction
    /* renamed from: 下一个 */
    public String m5444() {
        return (String) this.iterator.next();
    }

    @SimpleFunction
    /* renamed from: 到起始位置 */
    public void m5446() {
        this.iterator = this.map.keySet().iterator();
    }

    @SimpleFunction
    /* renamed from: 取项目总数 */
    public int m5449() {
        return this.map.size();
    }

    @SimpleFunction
    /* renamed from: 是否包含 */
    public boolean m5450(String key) {
        return this.map.containsKey(key);
    }

    @SimpleFunction
    /* renamed from: 删除项目 */
    public void m5445(String key) {
        this.map.remove(key);
        this.iterator = this.map.keySet().iterator();
    }
}
