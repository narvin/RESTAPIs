package main.java.com.rapis.controller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import main.java.com.rapis.service.AppPropService;
import main.java.com.rapis.service.impl.AppPropServiceImpl;
//import test.java.com.rapis.controller.AppControllerTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.rapis.domain.AppProp;
@EnableAutoConfiguration
@RestController
public class AppController {

	private static final Logger LOGGER = Logger.getLogger(AppController.class);
	
	
	@Autowired(required=true)
		private AppPropService apService;

	@GetMapping(value = "/api/{appCode}/config/{version}/")
		public ResponseEntity<AppProp> retrieveProperties(@PathVariable String appCode, @PathVariable String version) {
			 LOGGER.info("application properties to fetch: ");
			 LOGGER.info(appCode +" "+version);
			AppProp ap= apService.retrieveProp(appCode,version);
			LOGGER.info(ap);
			return ResponseEntity.status(HttpStatus.OK).body(ap);
		}
		
		@GetMapping("/api/{appCode}/config/")
		public ResponseEntity<String> retrieveAppCode(@PathVariable String appCode) {
			LOGGER.info("application properties to fetch by appCode: ");
			String ap= apService.retrieveCode(appCode);
			LOGGER.info(ap);
			return ResponseEntity.status(HttpStatus.OK).body(ap);
		}
		
		@PostMapping("/appl/{appCode}/config/{version}/")
		public ResponseEntity<String> saveProperties(@PathVariable String appCode, @PathVariable String version) {
			LOGGER.info("application properties to save by appCode----------: ");
			 apService.save(appCode, version);
			return ResponseEntity.status(HttpStatus.OK).body("Ok");
		}

}

