package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@GetMapping("/hello")
	@ResponseBody
	public String sayHellos() {
		return "Hello SK!";

	}

	@GetMapping("/hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuilder htmlBuffer = new StringBuilder();
		htmlBuffer.append("<html>");
		htmlBuffer.append("<head>");
		htmlBuffer.append("<title>").append("Rains").append("</title>");
		htmlBuffer.append("</head>");
		htmlBuffer.append("<body>");
		htmlBuffer.append("<h1>");
		htmlBuffer.append("Welcome to Rains world");
		htmlBuffer.append("</h1>");
		htmlBuffer.append("</body>");
		htmlBuffer.append("</html>");
		return htmlBuffer.toString();
	}

	@GetMapping("hello-html-jsp")
	public String sayHello() {
		return "sayHello";
	}
}
