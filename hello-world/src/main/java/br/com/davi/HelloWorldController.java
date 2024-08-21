package br.com.davi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private final String template = "Hello %s! ";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/hello")
	public HelloWorld hello(
			@RequestParam(value = "name", defaultValue = "World")String name) {
				return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
		
	}

	
}
