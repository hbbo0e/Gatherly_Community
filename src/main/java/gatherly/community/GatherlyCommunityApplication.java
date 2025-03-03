package gatherly.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {H2ConsoleAutoConfiguration.class}) // check
public class GatherlyCommunityApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatherlyCommunityApplication.class, args);
  }

}