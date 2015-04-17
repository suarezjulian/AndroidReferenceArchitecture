package com.globant.mvp;

import android.os.Bundle;

/**
 * Created by j.suarez on 4/14/2015.
 */
public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView(boolean retain);

    void onCreate(Bundle savedInstanceState);

    void onSaveInstanceState(Bundle outState);
}
