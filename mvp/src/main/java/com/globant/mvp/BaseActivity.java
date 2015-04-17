package com.globant.mvp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import butterknife.ButterKnife;

/**
 * Created by j.suarez on 4/14/2015.
 */
public abstract class BaseActivity<P extends BasePresenter> extends ActionBarActivity implements BaseView {

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        presenter = createPresenter();
        if (presenter == null){
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        presenter.attachView(this);
    }

    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();
        ButterKnife.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }

    protected abstract P createPresenter();
    protected abstract void injectDependencies();
}
