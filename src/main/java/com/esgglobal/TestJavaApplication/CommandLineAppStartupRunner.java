package com.esgglobal.TestJavaApplication;

import com.esgglobal.TestJavaApplication.utils.CustomerFileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLineAppStartupRunner implements ApplicationRunner {

    @Autowired
    CustomerFileHandler fileHandler;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<String> firstArg = Arrays.stream(args.getSourceArgs()).findFirst();
        boolean allowScanning = ! (firstArg.isPresent() && firstArg.get().equals("no-scanning"));
        if (allowScanning)
            scan();
    }

    private void scan() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
  Welcome to the customers console app!!!
  Please enter the folder/directory path:""");
        String folderPath = scanner.nextLine();
        System.out.println("Please enter the file name:");
        String fileName = scanner.nextLine();
        scanner.close();
        fileHandler.handle(folderPath, fileName);
        System.out.println("Successfully saved customers");
    }
}
