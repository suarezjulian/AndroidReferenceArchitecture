package com.tech.freak.referencearchitecture;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by j.suarez on 4/15/2015.
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void inject(ReferenceArchitectureApp referenceArchitectureApp);

    ReferenceArchitectureApp referenceArchitectureApp();

    OkHttpClient okHttpClient();
}
