package org.itstep.webapp.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

  @Bean
  public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

  @Bean
  public CookieLocaleResolver localeResolver(){
    CookieLocaleResolver cookie = new CookieLocaleResolver();
    cookie.setCookieMaxAge(3600*24*30);
    cookie.setCookieName("language");
    cookie.setDefaultLocale(new Locale("en"));
    return cookie;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor(){
    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
    interceptor.setParamName("lang");
    return interceptor;
  }

  @Override public void addInterceptors(final InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }
}
