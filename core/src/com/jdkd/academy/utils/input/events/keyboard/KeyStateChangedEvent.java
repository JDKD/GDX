package com.jdkd.academy.utils.input.events.keyboard;

import com.jdkd.academy.utils.events.Event;

public class KeyStateChangedEvent implements Event {

    private int keycode;
    private boolean wasPressed;

    public KeyStateChangedEvent(int keycode, boolean wasPressed) {
        this.keycode = keycode;
        this.wasPressed = wasPressed;
    }

    public int getKeycode() {
        return keycode;
    }

    public boolean wasPressed() {
        return wasPressed;
    }
}
