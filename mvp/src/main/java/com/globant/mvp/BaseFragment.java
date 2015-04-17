package com.globant.mvp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by j.suarez on 4/14/2015.
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView{

    protected P presenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectDependencies();
        ButterKnife.inject(this, view);
        // Create the presenter if needed
        if (presenter == null) {
            presenter = createPresenter();

            if (presenter == null){
                throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
            }
        }
        presenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        ButterKnife.reset(this);
        presenter.detachView(getRetainInstance());
        super.onDestroyView();
    }

    protected abstract void injectDependencies();
    protected abstract P createPresenter();
}
