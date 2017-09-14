package com.jdkd.academy.utils.input.events.keyboard;

import com.jdkd.academy.utils.events.EventHandler;

import java.util.HashSet;
import java.util.Set;

public class KeyStateChangedEventHandler implements EventHandler<KeyStateChangedEvent> {

    private static final KeyStateChangedEventHandler instance = new KeyStateChangedEventHandler();

    private Set<KeyChangeListener> listeners;

    private KeyStateChangedEventHandler() {
        listeners = new HashSet<>();
    }

    public static KeyStateChangedEventHandler getInstance() {
        return instance;
    }

    public void addListener(KeyChangeListener listener) {
        listeners.add(listener);
    }

    public void removeListener(KeyChangeListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void handle(KeyStateChangedEvent event) {
        for (KeyChangeListener listener : listeners) {
            listener.onKeyStateChanged(event);
        }
    }

    @Override
    public Class<KeyStateChangedEvent> getEventType() {
        return KeyStateChangedEvent.class;
    }
}
