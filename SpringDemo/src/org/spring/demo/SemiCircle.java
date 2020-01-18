package org.spring.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component // with this annotation, we can avoid defining the bean in spring.xml. in this case semicircle bean will be initilized  
public class SemiCircle  implements ShapeInterface , ApplicationEventPublisherAware{
	
	private Point radius;
	private ApplicationEventPublisher publisher;
	@Autowired // here were are autowiring by type.ResourceBundlemMessageSource in spring xml is same type as that of MessageSource in this class. 
	private MessageSource messageSourceabc; // The instance of messageBean in spring xml is being made availeble in this class via MessageSource interface.
	
   
	@Override
	public void draw() {
		System.out.println( "Printing values from messages.proerties file : "+this.messageSourceabc.getMessage("drawing.message",new Object [] {radius.getX(),radius.getY()}, "default message", null));
		System.out.println( "Printing values from messages.proerties file : " +this.messageSourceabc.getMessage("country",null, "default country", null));
		//System.out.println( "Printing values from messages.proerties file : " +messageSource.getMessage("key in propertiesfile",parameter, "default MESSAGE ", locale));
		DrawEvent drawEvent = new DrawEvent(this); // this --> the class in which the event is created. Here it is DrawEvent
		publisher.publishEvent(drawEvent);
	}

	
	public MessageSource getMessageSourceabc() {
		return messageSourceabc;
	}


	public void setMessageSourceabc(MessageSource messageSourceabc) {
		this.messageSourceabc = messageSourceabc;
	}


	public Point getRadius() {
		return radius;
	}

	@Resource(name="pointCRef") //  @resource looks for the bean pointC in spring.xml and inject the dependency values from spring.xml
	// if the name is not specified, by default it takes teh name of the member variable i.e radius and will look in spring.xml for a bean named radius
	public void setRadius(Point radius) {
		this.radius = radius;
	}
	
	
	
  
	@PostConstruct
	public void initializeSemiCircle() // (this will be called when the semicircle bean itself is initialized)
	{
		System.out.println("JSR 250 annotation @postconstruct demo : Init of Semicircle");
	}
	
    @PreDestroy
	public void destroySemiCircle() 
	{
		System.out.println("JSR 250 annotation @predestroy demo : Destroy of Semicircle");
	}


	@Override // publisher object  (springPublisher) is provided by spring to this semicirle bean and it is associated with the local variable publisher
	public void setApplicationEventPublisher(ApplicationEventPublisher springPublisher) {
		this.publisher=springPublisher;
		
	}
}
