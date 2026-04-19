package org.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ChainEventBus {
    private final List<Consumer<ChainEvent>> subscribers;

    public ChainEventBus() {
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(Consumer<ChainEvent> consumer) {
        subscribers.add(consumer);
    }

    public void publish(ChainEvent event) {
        for (Consumer<ChainEvent> sub : subscribers) {
            sub.accept(event);
        }
    }
}

class ChainEvent {
    private final String type;
    private final Object data;

    public ChainEvent(String type, Object data) {
        this.type = type;
        this.data = data;
    }
}
