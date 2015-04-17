package com.tech.freak.referencearchitecture.main.data;

import com.tech.freak.referencearchitecture.model.Jokes;
import com.tech.freak.referencearchitecture.network.Api;

import rx.Observable;

/**
 * Created by j.suarez on 4/14/2015.
 */
public class JokeDao {

    private final Api api;

    public JokeDao(Api api) {
        this.api = api;
    }

    public Observable<Jokes> getJokesObserver(int number) {
        return api.getRandomJokes(number);
    }
}
