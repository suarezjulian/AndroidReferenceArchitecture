package com.tech.freak.referencearchitecture.main;

import android.os.Bundle;
import android.util.Log;

import com.globant.mvp.rx.AndroidSchedulerTransformer;
import com.tech.freak.referencearchitecture.main.data.JokeDao;
import com.tech.freak.referencearchitecture.model.Jokes;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by j.suarez on 4/14/2015.
 */
public class MainPresenterImpl implements MainPresenter {

    public static final int JOKE_NUMBER = 10;
    public static final String JOKES = "jokes";

    private MainView mainView;

    private JokeDao jokeDao;

    protected Subscriber<Jokes> subscriber;
    private Jokes jokes;

    public MainPresenterImpl(JokeDao jokeDao) {
        this.jokeDao = jokeDao;
        Log.d(MainPresenterImpl.class.getSimpleName(), "Creating new MainPresenterImpl");
    }

    @Override
    public void attachView(MainView view) {
        mainView = view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            loadData();
        } else {
            jokes = (Jokes) savedInstanceState.getSerializable(JOKES);
            if (mainView != null && jokes != null) {
                mainView.showJokes(jokes);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(JOKES, jokes);
    }

    @Override
    public void loadData() {
        if (mainView != null) {
            mainView.showLoading();
        }

        Observable<Jokes> randomJokesObservable = jokeDao.getJokesObserver(JOKE_NUMBER);

        subscriber = new Subscriber<Jokes>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                if (mainView != null) {
                    mainView.showError(e);
                }
                unsubscribe();
            }

            @Override
            public void onNext(Jokes jokes) {
                if (mainView != null) {
                    MainPresenterImpl.this.jokes = jokes;
                    if (jokes == null) {
                        mainView.showError(new Exception("No jokes found"));
                    } else {
                        mainView.showJokes(jokes);
                    }
                }
                unsubscribe();
            }
        };
        randomJokesObservable = applyScheduler(randomJokesObservable);
        randomJokesObservable.subscribe(subscriber);
    }

    @Override
    public void detachView(boolean retain) {
        mainView = null;
        Log.d(MainPresenterImpl.class.getSimpleName(), "detachView");
        unsubscribe();
    }

    private Observable<Jokes> applyScheduler(Observable<Jokes> observable) {
        return observable.compose(new AndroidSchedulerTransformer<Jokes>());
    }


    private void unsubscribe() {
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }
}
