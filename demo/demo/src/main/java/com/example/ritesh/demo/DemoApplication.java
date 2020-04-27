package com.example.ritesh.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
@SpringBootConfiguration
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
  @Bean
 public  LocaleResolver localResolver() {
	  //SessionLocaleResolver localeResolver =new SessionLocaleResolver();
	  AcceptHeaderLocaleResolver localeResolver =new AcceptHeaderLocaleResolver();
	  localeResolver.setDefaultLocale(Locale.US);;
	  return localeResolver;
  }
	/*
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() {
	 * ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
	 * messageSource.setBasename("messages"); return messageSource;
	 * 
	 * }
	 */
}
