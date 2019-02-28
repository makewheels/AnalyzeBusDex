package com.amap.api.p015a;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: SyncList */
/* renamed from: com.amap.api.a.bq */
public class bq<T> implements List<T> {
    /* renamed from: a */
    protected LinkedList<T> f635a = new LinkedList();

    /* renamed from: a */
    public synchronized void m1057a(T t) {
        add(t);
    }

    public synchronized void add(int i, T t) {
        this.f635a.add(i, t);
    }

    public synchronized boolean addAll(Collection<? extends T> collection) {
        return this.f635a.addAll(collection);
    }

    public synchronized boolean addAll(int i, Collection<? extends T> collection) {
        return this.f635a.addAll(i, collection);
    }

    public synchronized void clear() {
        this.f635a.clear();
    }

    public synchronized boolean contains(Object obj) {
        return this.f635a.contains(obj);
    }

    public synchronized boolean containsAll(Collection<?> collection) {
        return this.f635a.containsAll(collection);
    }

    public synchronized T get(int i) {
        T t;
        t = null;
        try {
            t = this.f635a.get(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public synchronized int indexOf(Object obj) {
        return this.f635a.indexOf(obj);
    }

    public synchronized boolean isEmpty() {
        return this.f635a.isEmpty();
    }

    public synchronized Iterator<T> iterator() {
        return this.f635a.listIterator();
    }

    public synchronized int lastIndexOf(Object obj) {
        return this.f635a.lastIndexOf(obj);
    }

    public synchronized ListIterator<T> listIterator() {
        return this.f635a.listIterator();
    }

    public synchronized ListIterator<T> listIterator(int i) {
        return this.f635a.listIterator(i);
    }

    public synchronized T remove(int i) {
        return this.f635a.remove(i);
    }

    public synchronized boolean remove(Object obj) {
        return this.f635a.remove(obj);
    }

    public synchronized boolean removeAll(Collection<?> collection) {
        return this.f635a.removeAll(collection);
    }

    public synchronized boolean retainAll(Collection<?> collection) {
        return this.f635a.retainAll(collection);
    }

    public synchronized T set(int i, T t) {
        return this.f635a.set(i, t);
    }

    public synchronized int size() {
        return this.f635a.size();
    }

    public synchronized List<T> subList(int i, int i2) {
        return this.f635a.subList(i, i2);
    }

    public synchronized Object[] toArray() {
        return this.f635a.toArray();
    }

    public synchronized <V> V[] toArray(V[] vArr) {
        return this.f635a.toArray(vArr);
    }

    public synchronized boolean add(T t) {
        return this.f635a.add(t);
    }
}
