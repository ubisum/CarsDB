package it.CarsDB.boot;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CarsDBApplication {
	
	/* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(CarsDBApplication.class.getName());
	
	public static void main(String[] args) throws Exception{
		log.debug("Hello this is a debug message");
	    log.info("Hello this is an info message");
		SpringApplication.run(CarsDBApplication.class, args);
	}
}
