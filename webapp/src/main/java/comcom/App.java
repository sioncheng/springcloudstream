package comcom;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements ApplicationRunner {



    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
