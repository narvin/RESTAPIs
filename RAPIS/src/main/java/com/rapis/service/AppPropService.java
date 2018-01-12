package main.java.com.rapis.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import main.java.com.rapis.domain.AppProp;
@Component
public interface AppPropService {
	
	public AppProp retrieveProp(String appCode, String version);
//	public List<AppProp> retrieveAll(String appCode, String version);
	public String retrieveCode(String appCode);
	public void save(String appCode, String version);
}
