package me.estrela.jvt;

import java.time.Duration;

import static me.estrela.jvt.ThreadUtils.describe;

public class MultipleVirtualThreads {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                Thread.sleep(Duration.ofMinutes(30));
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        };
        for (int i = 0; i < 100_000_000; i++) {
            Thread vThread = Thread.ofVirtual()
                    .name("virtual-thread")
                    .start(runnable);
            System.out.println(describe(vThread));
        }

    }

}
