package com.globant.mvp.rx;

import rx.Observable;

/**
 * Created by j.suarez on 4/14/2015.
 */
public interface SchedulerTransformer<T> extends Observable.Transformer<T, T> {
}
