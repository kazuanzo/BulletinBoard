package bulletinBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class bulletinBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(bulletinBoardApplication.class, args);
	}
}
