/**
 * 
 */
package com.lazzuardi.webs.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Adi
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.lazzuardi.webs")
public class WebConfig extends WebMvcConfigurerAdapter{

}
