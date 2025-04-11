package com.sam.beanCreationApplicationStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanListener implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        System.out.println("All Beans:");
        for (String beanName : beanNames) {
            try {
                // Optionally check for scope (not directly possible, but you can avoid specific beans)
                Object bean = applicationContext.getBean(beanName);
                System.out.println("Bean: " + beanName + " of type " + bean.getClass().getName());
            } catch (Exception e) {
                if (e.getMessage().contains("Scope 'request' is not active")) {
                    System.out.println("Skipping request-scoped bean: " + beanName + " because request scope is not active.");
                }   else if (e.getMessage().contains("Could not instantiate prototype")) {
                    System.out.println("Skipping prototype-scoped bean: " + beanName + " because it cannot be instantiated without a proper context.");
                } else {
                    System.out.println("Bean: " + beanName + " could not be instantiated. Reason: " + e.getMessage());
                }
            }
        }
    }
}
