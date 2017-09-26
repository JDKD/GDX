package com.jdkd.academy.world.entities;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jdkd.academy.utils.input.events.keyboard.KeyChangeListener;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEvent;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEventHandler;

public class Player extends Image implements KeyChangeListener {

    private static final int SPEED = 500;

    private int vX, vY;

    public Player() {
        super(new Texture("badlogic.jpg"));
        KeyStateChangedEventHandler.getInstance().addListener(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBy(vX * delta, vY * delta);
    }

    @Override
    public void onKeyStateChanged(KeyStateChangedEvent event) {
        int modifier = event.wasPressed() ? 1 : -1;

        switch (event.getKeycode()) {
            case Input.Keys.A:
                vX -= SPEED * modifier;
                break;
            case Input.Keys.D:
                vX += SPEED * modifier;
                break;
            case Input.Keys.W:
                vY += SPEED * modifier;
                break;
            case Input.Keys.S:
                vY -= SPEED * modifier;
                break;
        }
    }
}
