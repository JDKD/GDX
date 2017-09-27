package com.jdkd.academy.world.entities;

import com.badlogic.gdx.Input;
import com.jdkd.academy.utils.input.events.keyboard.KeyChangeListener;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEvent;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEventHandler;

public class Player implements KeyChangeListener {

    private static final int SPEED = 500;
    private int vX, vY;
    private int x, y;

    public Player() {
        KeyStateChangedEventHandler.getInstance().addListener(this);
    }


    public void update(float delta) {
        this.x += vX*delta;
        this.y += vY*delta;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
