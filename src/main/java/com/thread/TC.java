package com.thread;

public class TC {

    private static ThreadLocal<ThreadConstant> setup = new ThreadLocal<>();
    public static void set(ThreadConstant TC)
    {
        setup.set(TC);
    }

    public static ThreadConstant get()
    {
        return setup.get();
    }
}