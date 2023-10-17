package ehealthcare.com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ehealthcare")		// Enable @Restcontroller, @service , @repository annotation 
@EntityScan(basePackages = "ehealthcare.com.entity")			// Enable @Entity annotation  
@EnableJpaRepositories(basePackages = "ehealthcare.com.repository")	// Spring data features 
public class EHealthCareBackendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EHealthCareBackendAppApplication.class, args);
		System.out.println("spring boot up");
	}

}
