package com.e4a.runtime.components;

public interface ComponentContainer {
    void addComponent(Component component);

    Layout getLayout();
}
