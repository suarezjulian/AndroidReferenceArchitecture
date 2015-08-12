package com.tech.freak.referencearchitecture.presentation.main;

import javax.inject.Inject;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.InjectView;

import com.globant.mvp.BaseActivity;
import com.tech.freak.referencearchitecture.R;
import com.tech.freak.referencearchitecture.data.model.Jokes;
import com.tech.freak.referencearchitecture.presentation.ReferenceArchitectureApp;
import com.tech.freak.referencearchitecture.presentation.main.adapters.DividerItemDecoration;
import com.tech.freak.referencearchitecture.presentation.main.adapters.JokesAdapter;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;

    @InjectView(R.id.textViewError)
    TextView textViewError;

    @InjectView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    JokesAdapter jokesAdapter;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mainPresenter.onCreate(savedInstanceState);
    }

    @Override
    protected MainPresenter createPresenter() {
        return mainPresenter;
    }

    @Override
    protected void injectDependencies() {
        MainComponent mainComponent = DaggerMainComponent.builder()
                .appComponent(((ReferenceArchitectureApp) getApplication()).getAppComponent())
                .mainModule(new MainModule(this)).build();
        mainComponent.inject(this);
    }

    @Override
    public void showJokes(Jokes jokes) {
        jokesAdapter.setData(jokes);
        recyclerView.setVisibility(View.VISIBLE);
        textViewError.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(Throwable e) {
        recyclerView.setVisibility(View.GONE);
        textViewError.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

        textViewError.setText(R.string.error_msg);
        Log.e(MainActivity.class.getSimpleName(), "Error ", e);
    }

    @Override
    public void showLoading() {
        recyclerView.setVisibility(View.GONE);
        textViewError.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mainPresenter.onSaveInstanceState(outState);
    }

    private void initViews() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        jokesAdapter = new JokesAdapter();
        recyclerView.setAdapter(jokesAdapter);
    }
}
