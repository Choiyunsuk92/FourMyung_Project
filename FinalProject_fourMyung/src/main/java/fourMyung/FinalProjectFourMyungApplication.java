package fourMyung;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("fourMyung")
@MapperScan(basePackages = "fourMyung.mapper")
public class FinalProjectFourMyungApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectFourMyungApplication.class, args);
	}

}
