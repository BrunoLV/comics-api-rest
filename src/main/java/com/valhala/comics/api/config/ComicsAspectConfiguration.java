package com.valhala.comics.api.config;

import com.valhala.comics.api.aspects.LogAppAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by bruno on 12/05/16.
 */
@Configuration
@EnableAspectJAutoProxy
public class ComicsAspectConfiguration {

    @Bean
    public LogAppAspect logAppAspect() {
        return new LogAppAspect();
    }

}
