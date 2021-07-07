package hr.truenorth.TrueNorth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrueNorthApplication {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TrueNorthApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TrueNorthApplication.class, args);
		
		log.info("Application initialized.");
	}
	
}
