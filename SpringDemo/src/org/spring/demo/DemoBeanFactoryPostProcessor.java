package org.spring.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/*
 * This class DemoBeanFactoryPostProcessor initialized and then the  bean factory (application context) is initiliazed. This is the order.
 * */

public class DemoBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		System.out.println("In class DemoBeanFactoryPostProcessor, Method :postProcessBeanFactory  beanFactory  is  " + beanFactory);
		
	}

}
