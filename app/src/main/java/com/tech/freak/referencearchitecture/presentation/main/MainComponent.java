package com.tech.freak.referencearchitecture.presentation.main;

import com.tech.freak.referencearchitecture.presentation.ActivityScope;
import com.tech.freak.referencearchitecture.presentation.AppComponent;
import com.tech.freak.referencearchitecture.presentation.main.adapters.JokesAdapter;

import dagger.Component;

/**
 * Created by j.suarez on 4/14/2015.
 */
@Component(dependencies = AppComponent.class, modules = MainModule.class)
@ActivityScope
public interface MainComponent {
    void inject(MainActivity mainActivity);

    MainPresenter presenter();

    JokesAdapter adapter();
}
