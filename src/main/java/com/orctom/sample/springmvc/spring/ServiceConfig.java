package com.orctom.sample.springmvc.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Hao-Chen2 on 12/13/2014.
 */
@Configuration
@ComponentScan("com.orctom.sample.springmvc.service")
@Import({DataAccessConfig.class})
public class ServiceConfig {
}
