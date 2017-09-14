package com.jdkd.academy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jdkd.academy.utils.input.SingletonMultiplexer;
import com.jdkd.academy.utils.input.events.keyboard.KeyChangeListener;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEvent;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEventHandler;

public class AcademyGame extends ApplicationAdapter implements KeyChangeListener {
    SpriteBatch batch;
    Texture img;

    private static int speed = 5;
    private int x, y , vX, vY;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        Gdx.input.setInputProcessor(SingletonMultiplexer.getInstance());
        KeyStateChangedEventHandler.getInstance().addListener(this);
    }

    @Override
    public void render() {

        x += vX;
        y += vY;

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, x, y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    @Override
    public void onKeyStateChanged(KeyStateChangedEvent event) {

        int modifier = event.wasPressed() ? 1 : -1;

        switch (event.getKeycode()){
            case Input.Keys.A : vX -= speed  * modifier;
                break;
            case Input.Keys.D : vX += speed * modifier;
                break;
            case Input.Keys.W : vY += speed * modifier;
                break;
            case Input.Keys.S : vY -= speed  * modifier;
                break;
        }


    }
}
