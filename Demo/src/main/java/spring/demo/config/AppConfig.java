package spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration // with this annotation spring IOC understand that this class will handle all the Bean/obj configurations

// Method 1 using Component Scan----
@ComponentScan(basePackages = "spring.demo") // points to the base packages for scanning the beans
//----- Method 1 -----------
public class AppConfig {

}
