package com.tech.freak.referencearchitecture.presentation.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by j.suarez on 4/17/2015.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testShowJokes() throws Exception {

    }

    @Test
    public void testShowError() throws Exception {

    }

    @Test
    public void testShowLoading() throws Exception {

    }
}