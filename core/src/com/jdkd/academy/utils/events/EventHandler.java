package com.jdkd.academy.utils.events;

public interface EventHandler<T extends Event> {

    void handle(T event);

    Class<T> getEventType();

}
