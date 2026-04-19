package org.mq;

import java.util.LinkedList;
import java.util.Queue;

public class ChainMessageQueue {
    private final Queue<String> messageQueue;

    public ChainMessageQueue() {
        this.messageQueue = new LinkedList<>();
    }

    public void enqueueMessage(String message) {
        messageQueue.offer(message);
    }

    public String dequeueMessage() {
        return messageQueue.poll();
    }

    public int getQueueSize() {
        return messageQueue.size();
    }
}
