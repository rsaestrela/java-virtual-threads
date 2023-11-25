package me.estrela.jvt;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadsExecutors {

    public static void main(String[] args) {

        // Structured concurrency
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<Integer> future = executorService.submit(() -> 1 + 1);
            Integer result = future.get();
            System.out.printf("Task completed with result=%s", result);
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }

    }

}
