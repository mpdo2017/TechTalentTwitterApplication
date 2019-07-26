package com.tts.TechTalentTwitter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

/**
 * @author Michele Lanning
 * @version 2019-07-22
 */
@Configuration
public class ThymeleafConfiguration {
    @Bean
    public SpringSecurityDialect springSecurityDialect() {

        return new SpringSecurityDialect();
    }
}
