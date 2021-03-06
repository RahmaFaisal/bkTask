package main.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.services.CalculatorService;

import org.springframework.http.ResponseEntity;

@RestController
public class MainController {

	CalculatorService calculatorServiceobj;
	
	@PostMapping("/getResult")
	public String getResult(@RequestBody String test)
	{	
		calculatorServiceobj=new CalculatorService(test);
 		String res=calculatorServiceobj.getResult(calculatorServiceobj.chars, 0);
		return res;
	}
}
