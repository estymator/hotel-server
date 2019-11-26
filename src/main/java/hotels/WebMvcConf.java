package hotels;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConf implements  WebMvcConfigurer{
    @Bean
    public BCryptPasswordEncoder passwdEncoder()
    {
        BCryptPasswordEncoder cryptPasswd = new BCryptPasswordEncoder();
        return cryptPasswd;
    }
}
