package org.javadev.restservice; 

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/hi")
	public String hi(@RequestParam(value = "name", defaultValue = "World") String name) {
		return name;
	}
}
