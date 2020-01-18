package org.spring.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/*
 * This is called when every bean in spring.xml  is initialized. scenario - A init method that needs to be run across all beans.
 */
public class DemoBeanPostProcessor  implements BeanPostProcessor  {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println(" In postProcessAfterInitialization method in class DemoBeanPostProcessor, bean name is  " + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(" In postProcessBeforeInitialization method in class DemoBeanPostProcessor, bean name is  " + beanName);
		return bean;
	}

}
