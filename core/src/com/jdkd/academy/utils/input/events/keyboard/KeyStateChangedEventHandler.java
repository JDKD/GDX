package com.jdkd.academy.utils.input.events.keyboard;

import com.jdkd.academy.utils.events.EventHandler;

import java.util.HashSet;
import java.util.Set;

public class KeyStateChangedEventHandler implements EventHandler<KeyStateChangedEvent> {

    private static final KeyStateChangedEventHandler instance = new KeyStateChangedEventHandler();

    private Set<KeyChangeListener> listeners;
    private Set<KeyChangeListener> toRemove;

    private KeyStateChangedEventHandler() {
        listeners = new HashSet<>();
        toRemove = new HashSet<>();
    }

    public static KeyStateChangedEventHandler getInstance() {
        return instance;
    }

    public void addListener(KeyChangeListener listener) {
        listeners.add(listener);
    }

    public void removeListener(KeyChangeListener listener) {
        toRemove.add(listener);
    }

    private void removeListeners(){
        for(KeyChangeListener listener : toRemove){
            listeners.remove(listener);
        }

        toRemove.clear();
    }

    @Override
    public void handle(KeyStateChangedEvent event) {
        for (KeyChangeListener listener : listeners) {
            listener.onKeyStateChanged(event);
        }
        removeListeners();
    }

    @Override
    public Class<KeyStateChangedEvent> getEventType() {
        return KeyStateChangedEvent.class;
    }
}
