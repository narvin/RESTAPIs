package main.java.com.rapis;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
@EnableAutoConfiguration
@Configuration
public class RapisDemo implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(RapisDemo.class, args);
    }
	@Override
    public void run(String... args) throws Exception {
	}

}
