package me.estrela.jvt;

public final class ThreadUtils {

    public static String describe(Thread thread) {
        return String.format("Thread %s-%s isVirtual=%s status=%s activeThreads=%s",
                thread.getName(), thread.threadId(), thread.isVirtual(), thread.getState().name(), Thread.activeCount());
    }


}
