package test.java.com.rapis.controller;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import main.java.com.rapis.RapisDemo;
import main.java.com.rapis.controller.AppController;
import main.java.com.rapis.domain.AppProp;
import main.java.com.rapis.service.AppPropService;
import main.java.com.rapis.service.impl.AppPropServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(controllers = {AppController.class})
//@ContextConfiguration(classes={RapisDemo.class})
//@SpringApplicationConfiguration(classes = AppController.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RapisDemo.class)
@WebAppConfiguration
public class AppControllerTest {
	

	@Autowired
	private AppPropService appService;
	 private static final Logger LOGGER = Logger.getLogger(AppControllerTest.class);
	 
	 @Autowired
	    private WebApplicationContext wac;

	    private MockMvc mockMvc;

	    @Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }
	@Test
	public void retrievePropertiesTest() throws Exception {
		LOGGER.info("INFO TEST");
//		AppProp ap=new AppProp("app1","v1");
//		 Mockito.when(
//				 appService.retrieveProp("app1","v1")).thenReturn(ap);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/app1/config/v1/")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		LOGGER.info("INFO TEST complete");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());


	}
	@Test
	public void retrieveAppCodeTest() throws Exception {
//		AppProp mockAppProp = new AppProp();
//
//		String exampleCourseJson = "{\"appCode\":\"app3\",\"version\":\"v3\"}";
		LOGGER.info("INFO TEST2-------------------");
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/app1/config/")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	}
	@Test
	public void saveAppCodeTest() throws Exception {
		LOGGER.info("INFO TEST3-------------------");
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/app1/config/v1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	}

}
