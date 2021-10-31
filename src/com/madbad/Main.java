package com.madbad;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        long memory1;
        long memory2;
        String someints[] = new String[10000];
        System.out.println("Вся память: " + runtime.totalMemory());
        memory1 = runtime.freeMemory();
        System.out.println("Оставшаяся свободная память: " + memory1);
        runtime.gc();
        memory1 = runtime.freeMemory();
        System.out.println("Свободная память, после сборки мусора: " + memory1);
        for (int i = 0; i < 10000; i++)
            someints[i] = i+"";
        memory2 = runtime.freeMemory();
        System.out.println("Свободная память после выделения: " + memory2);
        System.out.println("Память, используемая при выделении: " + (memory1 - memory2));
        // discard Integers
        for (int i = 0; i < 10000; i++)
            someints[i] = null;
        runtime.gc();
        Thread.sleep(100);
        memory2 = runtime.freeMemory();
        System.out.println("Итоговая свободная память: " + memory2);
    }
}
