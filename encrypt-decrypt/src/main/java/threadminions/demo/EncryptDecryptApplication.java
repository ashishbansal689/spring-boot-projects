package threadminions.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncryptDecryptApplication implements CommandLineRunner {

	@Value("${server.password}")
	String serverPassword;

	public static void main(String[] args) {
		SpringApplication.run(EncryptDecryptApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server password is: " + serverPassword);
	}
}
