package io.codeforall.fanstatics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<String> GEThelloWorld(@RequestParam(value = "name", defaultValue = "World") String str) {

        return new ResponseEntity<String>("GET: Hello " + str, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<String> POSThelloWorld(@RequestParam(value = "name", defaultValue = "World") String str) {

        return new ResponseEntity<String>("POST: Hello " + str, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public ResponseEntity<String> PUThelloWorld(@RequestParam(value = "name", defaultValue = "World") String str) {

        return new ResponseEntity<String>("PUT: Hello " + str, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public ResponseEntity<String> DELETEhelloWorld(@RequestParam(value = "name", defaultValue = "World") String str) {

        return new ResponseEntity<String>("DELETE: Hello " + str, HttpStatus.OK);
    }

}
