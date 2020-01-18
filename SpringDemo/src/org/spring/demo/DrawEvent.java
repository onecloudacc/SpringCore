package org.spring.demo;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {

	public DrawEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	
	public String toString()
	{
		return "My Draw Event Occured ";
		
	}
}
