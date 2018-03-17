package com.learning.sunny.basemvp.callback.base;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public interface Action1<T> extends Action {
    void call(T t);
}
