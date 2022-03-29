package org.javadev.restservice; 

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("apples")
public class AppController {
	
	private int counter = 4;

	@GetMapping("/hi")
	public String hi(@RequestParam(value = "name", defaultValue = "World") String name) {
		return name;
	}
	
	// -------------
	
	private List<Map<String, String>> apples = new ArrayList<Map<String, String>>() {{
			add(new HashMap<String, String>() {{ put("id", "1"); put("text", "First apple"); }});
			add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Second apple"); }});
			add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Third apple"); }});
	}};

	@GetMapping
	  public List<Map<String, String>> list() {
	    return apples;
	  }
	
	
	// -----------
	
    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getMessage(id);
    }

    private Map<String, String> getMessage(@PathVariable String id) {
        return apples.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
    
    // ------------
    

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));
        apples.add(message);
        return message;
    }
    
    // ------------
    
    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDb = getMessage(id);

        messageFromDb.putAll(message);
        messageFromDb.put("id", id);

        return messageFromDb;
    }
    
    // ------------
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> message = getMessage(id);

        apples.remove(message);
    }
	
	
} // The End of Class;
