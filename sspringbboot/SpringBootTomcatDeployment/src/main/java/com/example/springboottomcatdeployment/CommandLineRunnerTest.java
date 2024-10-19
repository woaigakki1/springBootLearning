package com.example.springboottomcatdeployment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class CommandLineRunnerTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello world from command line runner");
    }

    public static void main(String[] args) {
        SpringApplication.run(CommandLineRunnerTest.class);
    }

}
