package main.java.com.rapis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@SpringBootApplication
@Component
@EnableJpaRepositories
@EnableAutoConfiguration
@Configuration
public class RapisDemo implements CommandLineRunner {

	 @Autowired
	    DataSource dataSource;
	public static void main(String[] args) {
        SpringApplication.run(RapisDemo.class, args);
    }
	@Override
    public void run(String... args) throws Exception {
	}

}
