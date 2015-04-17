package com.globant.mvp.rx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by j.suarez on 4/14/2015.
 */
public class AndroidSchedulerTransformer<T> implements SchedulerTransformer<T> {
    @Override public Observable<T> call(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
