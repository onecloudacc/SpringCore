package org.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Circle implements ShapeInterface{

	private Point center;
	@Override
	public void draw() {
		System.out.println( "Circle poinnt is " + center.getX()+","+center.getY());
		
	}
	public Point getCenter() {
		return center;
	}
	
	@Required
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	
}
