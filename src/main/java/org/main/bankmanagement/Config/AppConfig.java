package org.main.bankmanagement.Config;

import org.main.bankmanagement.Utility.BasedPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    BasedPasswordEncoder passwordEncoderSHA256()
    {
        return new BasedPasswordEncoder();
    }
}
