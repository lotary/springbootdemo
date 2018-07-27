package hello;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping("/hello-world")
    public Greeting sayHello(@RequestParam(name="name", required = false, defaultValue = "Stranger") 
    							String name) {
    	return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
