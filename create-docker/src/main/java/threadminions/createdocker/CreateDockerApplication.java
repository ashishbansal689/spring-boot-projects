package threadminions.createdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CreateDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreateDockerApplication.class, args);
    }


}


@RestController
class DockerController {
    @GetMapping("testDocker")
    public Object testDocker() {
        return "Docker is running";
    }
}
