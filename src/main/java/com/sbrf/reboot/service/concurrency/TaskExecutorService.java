package com.sbrf.reboot.service.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutorService {

    private final int numberOfThreads;

    private final ExecutorService service;

    public TaskExecutorService(int numberOfThreads) {
        this.service = Executors.newFixedThreadPool(numberOfThreads);
        this.numberOfThreads = numberOfThreads;
    }

    public void execute(Task task) {
        int count = 0;
        while (count < numberOfThreads) {
            service.execute(task);
            count++;
        }

    }

    public void shutdown() {
        service.shutdown();
    }

}
