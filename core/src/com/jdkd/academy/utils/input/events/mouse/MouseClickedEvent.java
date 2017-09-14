package com.jdkd.academy.utils.input.events.mouse;

import com.jdkd.academy.utils.events.Event;

public class MouseClickedEvent implements Event {

    private int button;
    private float x, y;

    public MouseClickedEvent(int button, float x, float y) {
        this.button = button;
        this.x = x;
        this.y = y;
    }

    public int getButton() {
        return button;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
