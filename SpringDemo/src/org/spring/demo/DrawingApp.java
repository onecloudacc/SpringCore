package org.spring.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//BeanFactory factory= new XmlBeanFactory(new FileSystemResource("spring.xml")); // Load the spring.xml (it can be any name) If you are using beanfactory, make sure the spring xml is in the root of the project directory
		//ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
		/* If you are using the applicationcontext (which is recommneded because , it includes the function of beanfactory and and some other funtions on top of that), place the file in class path, i.e under src folder.
		//alternatively if you are trying to make use of "destroy" method in triangle bean, then you should go with AbstractApplicationContext mentioned below*/
		AbstractApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
		factory.registerShutdownHook(); // if this line of code is not present, any of teh destroy methods in the beans will NOT work.
	//	Triangle triangle= (Triangle) factory.getBean("triangle-ref");
		//triangle.drawTriangle();
		//ShapeInterface shape = (ShapeInterface) factory.getBean("triangleId");
	//	ShapeInterface shape = (ShapeInterface) factory.getBean("circle"); // codiing by interfaces
		ShapeInterface shape = (ShapeInterface) factory.getBean("semiCircle"); // codiing by interfaces
		shape.draw();
	}

}
