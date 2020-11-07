package com.centerprime.quarkchainsdk.quarck;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Async task facilitation.
 */
public class Async {

    private static ExecutorService executorService;

    static {
        executorService = Executors.newCachedThreadPool();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                shutdown(executorService);
            }
        }));
    }

    static {
        executorService = defaultExecutorService();
    }

    public static <T> Future<T> run(Callable<T> callable) {
        return executorService.submit(callable);
    }

    private static int getCpuCount() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Provide a new ScheduledExecutorService instance.
     * <p>
     * <p>A shutdown hook is created to terminate the thread pool on application termination.
     *
     * @return new ScheduledExecutorService
     */
    public static ScheduledExecutorService defaultExecutorService() {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(getCpuCount());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> shutdown(scheduledExecutorService)));

        return scheduledExecutorService;
    }

    /**
     * Shutdown as per {@link ExecutorService} Javadoc recommendation.
     *
     * @param executorService executor service we wish to shut down.
     */
    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Thread pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
