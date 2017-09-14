package com.jdkd.academy.utils.events;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class EventHandlerRegistry {

    private static EventHandlerRegistry instance = new EventHandlerRegistry();
    private HashMap<Class<? extends Event>, Set<EventHandler<Event>>> handlers;

    private EventHandlerRegistry() {
        handlers = new HashMap<Class<? extends Event>, Set<EventHandler<Event>>>();
    }

    public static EventHandlerRegistry getInstance() {
        return instance;
    }

    public void postEvent(Event event) {
        Set<EventHandler<Event>> handlerList = handlers.get(event.getClass());
        if (handlerList != null) {
            for (EventHandler<Event> handler : handlerList) {
                handler.handle(event);
            }
        }
    }

    public void subscribe(EventHandler handler) {
        Set<EventHandler<Event>> handlerList = handlers.get(handler.getEventType());

        if (handlerList == null) {
            handlerList = new HashSet<>();
        }

        handlerList.add(handler);

        handlers.put(handler.getEventType(), handlerList);
    }

    public void unsubscribe(EventHandler handler) {
        if (handlers.containsKey(handler.getEventType())) {
            handlers.remove(handler.getEventType());
        }
    }
}
