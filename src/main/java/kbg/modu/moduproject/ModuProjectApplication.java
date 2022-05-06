package kbg.modu.moduproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ModuProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuProjectApplication.class, args);
    }

}
