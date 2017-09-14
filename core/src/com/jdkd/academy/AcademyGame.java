package com.jdkd.academy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jdkd.academy.screens.mainMenu.MainMenuScreen;
import com.jdkd.academy.utils.graphics.Assets;
import com.jdkd.academy.utils.input.SingletonMultiplexer;
import com.jdkd.academy.utils.input.events.keyboard.KeyChangeListener;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEvent;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEventHandler;

public class AcademyGame extends Game {

    @Override
    public void create() {
        Gdx.input.setInputProcessor(SingletonMultiplexer.getInstance());
        Assets.initialise();
        setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }

}
