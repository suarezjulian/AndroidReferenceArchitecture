package com.tech.freak.referencearchitecture.domain.network;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

import com.tech.freak.referencearchitecture.data.model.Jokes;

/**
 * Created by j.suarez on 4/14/2015.
 */
public interface Api {

    @GET("/jokes/random/{number}")
    Observable<Jokes> getRandomJokes(@Path("number") int number);

}
