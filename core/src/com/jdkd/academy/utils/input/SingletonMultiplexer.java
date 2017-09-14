package com.jdkd.academy.utils.input;

import com.badlogic.gdx.InputMultiplexer;

public class SingletonMultiplexer extends InputMultiplexer {

    public static final SingletonMultiplexer instance = new SingletonMultiplexer();

    private SingletonMultiplexer() {
        addProcessor(new CoreInputHandler());
    }

    public static SingletonMultiplexer getInstance() {
        return instance;
    }
}
