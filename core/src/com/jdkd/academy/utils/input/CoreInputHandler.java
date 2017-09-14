package com.jdkd.academy.utils.input;

import com.badlogic.gdx.InputProcessor;
import com.jdkd.academy.utils.events.EventHandlerRegistry;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEvent;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEventHandler;
import com.jdkd.academy.utils.input.events.mouse.MouseClickedEvent;
import com.jdkd.academy.utils.input.events.mouse.MouseClickedEventHandler;

public class CoreInputHandler implements InputProcessor {

    public CoreInputHandler() {
        EventHandlerRegistry.getInstance().subscribe(KeyStateChangedEventHandler.getInstance());
        EventHandlerRegistry.getInstance().subscribe(MouseClickedEventHandler.getInstance());
    }

    @Override
    public boolean keyDown(int keycode) {
        EventHandlerRegistry.getInstance().postEvent(new KeyStateChangedEvent(keycode, true));
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        EventHandlerRegistry.getInstance().postEvent(new KeyStateChangedEvent(keycode, false));
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        EventHandlerRegistry.getInstance().postEvent(new MouseClickedEvent(button, screenX, screenY));
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
