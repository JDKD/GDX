package com.jdkd.academy.utils.input.events.mouse;

import com.jdkd.academy.utils.events.EventHandler;

import java.util.HashSet;
import java.util.Set;

public class MouseClickedEventHandler implements EventHandler<MouseClickedEvent> {

    private static final MouseClickedEventHandler instance = new MouseClickedEventHandler();

    private Set<MouseClickedListener> listeners;

    private MouseClickedEventHandler() {
        listeners = new HashSet<>();
    }

    public static MouseClickedEventHandler getInstance() {
        return instance;
    }

    public void addListener(MouseClickedListener listener) {
        listeners.add(listener);
    }

    public void removeListener(MouseClickedListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void handle(MouseClickedEvent event) {
        for (MouseClickedListener listener : listeners) {
            listener.onMouseClicked(event);
        }
    }

    @Override
    public Class<MouseClickedEvent> getEventType() {
        return MouseClickedEvent.class;
    }
}
