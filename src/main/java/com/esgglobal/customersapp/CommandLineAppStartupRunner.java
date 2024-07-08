package com.esgglobal.customersapp;

import com.esgglobal.customersapp.utils.CustomerFileHandler;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class CommandLineAppStartupRunner implements ApplicationRunner {

    CustomerFileHandler fileHandler;
    private static final Logger LOG = Logger.getLogger(CommandLineAppStartupRunner.class.getName());
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Ready to start the command line app!");
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
