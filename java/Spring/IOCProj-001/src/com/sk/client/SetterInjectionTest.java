package com.sk.client;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.sk.sbeans.WishMessageGenerator;


public class SetterInjectionTest {

	public static void main(String[] args) {		
		//create the IOC container
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/sk/cfgs/applicationContext.xml");
		
		//get target spring bean class object ref from IOC container
		Object obj = ctx.getBean("wmg");
		//type casting
		WishMessageGenerator generator = (WishMessageGenerator)obj;           // WishMessageGenerator generator = (WishMessageGenerator)ctx.getBean("wmg"); 
		
		//invoke the business method
		String result = generator.generateWishMessage("ameen");
		System.out.println(result);
		
		//close the container
		ctx.close();
	}

}
