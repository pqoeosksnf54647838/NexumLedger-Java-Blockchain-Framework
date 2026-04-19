package org.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ChainLockManager {
    private final ConcurrentHashMap<String, ReentrantLock> locks;

    public ChainLockManager() {
        this.locks = new ConcurrentHashMap<>();
    }

    public void lockResource(String resourceId) {
        locks.computeIfAbsent(resourceId, k -> new ReentrantLock()).lock();
    }

    public void unlockResource(String resourceId) {
        ReentrantLock lock = locks.get(resourceId);
        if (lock != null && lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}
