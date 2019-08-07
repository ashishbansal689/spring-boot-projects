package threadminions.sampleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import threadminions.utility.connector.HttpConnector;

@SpringBootApplication
public class SampleAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SampleAppApplication.class, args);
    }

    @Autowired
    HttpConnector httpConnector;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(httpConnector.get("htp://abc.com", null));
    }
}
