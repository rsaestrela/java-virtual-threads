package me.estrela.jvt;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

import static me.estrela.jvt.ThreadUtils.describe;

public class MultiplePlatformThreads {

    public static void main(String[] args) {

        AtomicLong runningThreadsCounter = new AtomicLong();

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= 5_000; i++) {
            Thread vThread = Thread.ofPlatform()
                    .name("platform-thread")
                    .start(() -> {
                        runningThreadsCounter.incrementAndGet();
                        try {
                            Thread.sleep(Duration.ofMinutes(30));
                        } catch (InterruptedException e) {
                            // Let the thread die
                        }
                    });
            System.out.println(describe(vThread));
            if (i % 100 == 0) {
                long time = System.currentTimeMillis() - startTime;
                System.out.printf("%,d threads started, %,d threads running after %,d ms%n", i, runningThreadsCounter.get(), time);
            }
        }

    }

}

