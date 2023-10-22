package com.example.autobookrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OnBootstrap implements CommandLineRunner {
    private final DbInitializer dbInitializer;

    public OnBootstrap(DbInitializer dbInitializer) {
        this.dbInitializer = dbInitializer;
    }

    @Override
    public void run(String... args) {
        Thread thread = new Thread(dbInitializer);

        thread.start();
    }
}
