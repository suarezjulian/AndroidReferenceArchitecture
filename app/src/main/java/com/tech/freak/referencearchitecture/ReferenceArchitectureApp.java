package com.tech.freak.referencearchitecture;

import android.app.Application;

/**
 * Created by j.suarez on 4/15/2015.
 */
public class ReferenceArchitectureApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
