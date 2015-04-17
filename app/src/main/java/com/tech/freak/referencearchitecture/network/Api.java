package com.tech.freak.referencearchitecture.network;

import com.tech.freak.referencearchitecture.model.Jokes;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by j.suarez on 4/14/2015.
 */
public interface Api {

    @GET("/jokes/random/{number}")
    Observable<Jokes> getRandomJokes(@Path("number") int number);

}
