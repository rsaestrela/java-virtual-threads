package me.estrela.jvt;

import static me.estrela.jvt.ThreadUtils.describe;

public class VirtualThreadsStarter {

    public static void main(String[] args) throws InterruptedException {

        Thread vThread = Thread.ofVirtual()
                .name("virtual-thread")
                .start(() -> System.out.println("Started Virtual Thread!"));

        System.out.printf(describe(vThread));

        vThread.join();

        System.out.printf(describe(vThread));

    }

}
