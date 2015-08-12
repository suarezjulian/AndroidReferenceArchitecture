package com.tech.freak.referencearchitecture.domain.dao;

import rx.Observable;

import com.tech.freak.referencearchitecture.data.model.Jokes;
import com.tech.freak.referencearchitecture.domain.network.Api;

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
