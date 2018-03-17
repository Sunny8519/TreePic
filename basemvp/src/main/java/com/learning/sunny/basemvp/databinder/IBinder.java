package com.learning.sunny.basemvp.databinder;

import com.learning.sunny.basemvp.model.IModel;
import com.learning.sunny.basemvp.view.IDelegate;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public interface IBinder<V extends IDelegate, M extends IModel> {
    void modelBindView(M model, V viewDelegate);

    void viewBindModel(V viewDelegate, M model);
}
