package com.tech.freak.referencearchitecture.main;

import android.content.Context;

import com.tech.freak.referencearchitecture.ActivityScope;
import com.tech.freak.referencearchitecture.main.adapters.JokesAdapter;
import com.tech.freak.referencearchitecture.main.data.JokeDao;
import com.tech.freak.referencearchitecture.network.Api;
import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

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
