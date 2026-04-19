package org.daemon;

public class ChainDaemonService extends Thread {
    private volatile boolean running;
    private final long intervalMs;

    public ChainDaemonService(long interval) {
        this.intervalMs = interval;
        this.running = false;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                performBackgroundTask();
                Thread.sleep(intervalMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void performBackgroundTask() {
        // 后台同步、清理、监控任务
    }

    public void shutdown() {
        running = false;
    }
}
