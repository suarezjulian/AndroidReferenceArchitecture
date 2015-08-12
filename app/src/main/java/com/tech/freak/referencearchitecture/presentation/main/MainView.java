package com.tech.freak.referencearchitecture.presentation.main;

import com.globant.mvp.BaseView;
import com.tech.freak.referencearchitecture.data.model.Jokes;

/**
 * Created by j.suarez on 4/14/2015.
 */
public interface MainView extends BaseView {
    void showJokes(Jokes jokes);

    void showError(Throwable e);

    void showLoading();
}
