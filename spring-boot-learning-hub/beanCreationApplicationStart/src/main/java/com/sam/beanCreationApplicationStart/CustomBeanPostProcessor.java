package com.sam.beanCreationApplicationStart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // This method is called before a bean's initialization callback
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // Log the bean name and class for instantiated beans
        System.out.println("Instantiated bean: " + beanName + " of type " + bean.getClass().getName());
        return bean;
    }
}

