package odium.dar.DarServer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DarServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DarServerApplication.class, args);
    }
}
