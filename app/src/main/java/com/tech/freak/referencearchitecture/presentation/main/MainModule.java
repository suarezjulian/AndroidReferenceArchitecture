package com.tech.freak.referencearchitecture.presentation.main;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;
import com.tech.freak.referencearchitecture.domain.network.Api;
import com.tech.freak.referencearchitecture.presentation.ActivityScope;
import com.tech.freak.referencearchitecture.presentation.main.adapters.JokesAdapter;
import com.tech.freak.referencearchitecture.presentation.main.data.JokeDao;

import dagger.Module;
import dagger.Provides;

/**
 * Created by j.suarez on 4/14/2015.
 */
@Module
public class MainModule {

    private static final String ENDPOINT = "http://api.icndb.com";

    private Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    public Context provideContext() {
        return context;
    }

    @Provides
    @ActivityScope
    public Api provideApi(OkHttpClient okHttpClient) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setClient(new OkClient(okHttpClient))
                .build();
        return restAdapter.create(Api.class);
    }

    @Provides
    @ActivityScope
    public JokeDao provideJokeDao(Api api) {
        return new JokeDao(api);
    }

    @Provides
    @ActivityScope
    public JokesAdapter provideJokesAdapter() {
        return new JokesAdapter();
    }

    @Provides
    @ActivityScope
    public MainPresenter provideMainPresenter(JokeDao jokeDao) {
        return new MainPresenterImpl(jokeDao);
    }

}
