package com.learning.sunny.basemvp.callback.base;

import java.util.concurrent.Callable;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public interface Func0<R> extends Function, Callable<R> {
    @Override
    R call();
}
