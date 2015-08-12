package com.tech.freak.referencearchitecture.presentation;

import javax.inject.Singleton;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by j.suarez on 4/15/2015.
 */
@Module
public class AppModule {

    private static final int CACHE_SIZE = 10 * 1024 * 1024; // 10 MiB

    private ReferenceArchitectureApp app;

    public AppModule(ReferenceArchitectureApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public ReferenceArchitectureApp providesReferenceArchitectureApp() {
        return app;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(ReferenceArchitectureApp context) {
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setCache(new Cache(context.getCacheDir(), CACHE_SIZE));
        return okHttpClient;
    }
}
