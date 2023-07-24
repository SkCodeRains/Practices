package com.sk.sbeans;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator : 0-Param constructor");
	}
	
	//HAS-A Property(composition)
	@Autowired
	private LocalDateTime dateTime;

	//Setter method for setter injection
//	@Autowired                                                             //@Autowired on the top of setter method makes the IOC container to perform setter injection by calling the setter method.
//	public void setDateTime(LocalDateTime dateTime) {
//		System.out.println("WishMessageGenerator.setDateTime()");  
//		this.dateTime = dateTime;
//	}
	
	//business method
	public String generateWishMessage(String user)
	{
		System.out.println("WishMessageGenerator.generateWishMessage()");
		
		//get current hour of the day
		int hour = dateTime.getHour();
		
		//generate the wish message
		if(hour<12)
			return "Good Morning "+user;
		else if(hour<16)
			return "Good Afternoon "+user;
		else if(hour<20)
			return "Good Evening "+user;
		else 
			return "Good Night";
	}
}
