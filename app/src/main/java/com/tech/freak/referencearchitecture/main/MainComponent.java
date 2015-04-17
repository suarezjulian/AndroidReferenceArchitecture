package com.tech.freak.referencearchitecture.main;

import com.tech.freak.referencearchitecture.ActivityScope;
import com.tech.freak.referencearchitecture.AppComponent;
import com.tech.freak.referencearchitecture.main.adapters.JokesAdapter;

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
