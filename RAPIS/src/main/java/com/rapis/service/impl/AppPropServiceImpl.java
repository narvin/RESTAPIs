package main.java.com.rapis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.rapis.controller.AppController;
import main.java.com.rapis.domain.AppProp;
import main.java.com.rapis.repository.AppPropRepository;
//import main.java.com.rapis.repository.AppPropRepository;
import main.java.com.rapis.service.AppPropService;

@Transactional
@Service
public class AppPropServiceImpl implements AppPropService{
	private static final Logger LOGGER = Logger.getLogger(AppController.class);
	
	@Autowired
	private AppPropRepository apprepo;

	public AppPropServiceImpl(AppPropRepository apprepo) {
		this.apprepo = apprepo;
		
	}
	
	public static List<AppProp> approp =new ArrayList<>();
//	public static AppProp aprop = new AppProp();
//	public static AppProp aprop1 = new AppProp();
//	static{
//		
//		aprop.setCode("app1");
//		aprop.setVersion("v1");
//		aprop1.setCode("app2");
//		aprop1.setVersion("v2");
//		approp.add(aprop);
//		approp.add(aprop1);
//		LOGGER.info("----------------------------------"+approp);
//		}
	public void save(String appCode, String version) {
		LOGGER.info("hello--------------------");
		apprepo.save(appCode, version);
		
	}
	public AppProp retrieveProp(String appCode, String version){
		LOGGER.info("Service------------");
		AppProp ap=new AppProp("app1","v1");
		for(AppProp ap1:approp)	{
			if (ap1.getCode().equals(appCode)&& ap1.getVersion().equals(version)) {
				LOGGER.info(ap1.getCode());
				return ap;
			}
		}
		return null;
		}
	public String retrieveCode(String appCode){
		for(AppProp ap:approp)	{
			if (appCode.equals(ap.getCode())) {
				return ap.getVersion();
			}
		}
		return null;
		}
	}

