package fr.apside.sbik;

import java.util.HashMap;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.apside.sbik.util.Tools;
import fr.apside.sbik.util.ViewScope;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class);
    Tools.openBrowser("http://localhost:8080");
  }

  @Bean
  public static ViewScope viewScope() {
    return new ViewScope();
  }

  @Bean
  public CustomScopeConfigurer customScopeConfigurer() {
    CustomScopeConfigurer viewScope = new CustomScopeConfigurer();
    HashMap<String, Object> hashMap = new HashMap<String, Object>();
    hashMap.put("view", viewScope());
    viewScope.setScopes(hashMap);
    return viewScope;
  }
}
