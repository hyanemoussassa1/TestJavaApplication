package com.esgglobal.TestJavaApplication;

import com.esgglobal.TestJavaApplication.utils.CustomerFileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TestJavaApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestJavaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		Scanner scanner = new Scanner(System.in); // 2
		System.out.println("Welcome to your customers console app!");
		System.out.println("Please enter the folder/directory path:"); // 3
		String folderPath = scanner.nextLine();
		System.out.println("Please enter the file name:");
		String fileName = scanner.nextLine();
		scanner.close();
		double output;
		CustomerFileHandler fileHandler = new CustomerFileHandler();
		fileHandler.handle(folderPath, fileName);

		System.out.println("The result is given as follows:"); // 6
//		System.out.println(num1 + " " + operator + " " + num2 + " = " + output);

	}

}
