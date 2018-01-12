package main.java.com.rapis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.rapis.domain.AppProp;

@Repository
public interface AppPropRepository extends JpaRepository<AppProp, String>{
	@Query(value="inset into APPCODE values(appCode,version)", nativeQuery=true)
	public void save(@RequestParam String appCode, @RequestParam String version);
//	@Query(value="select * from APPCODE where APPCODE=appCode", nativeQuery=true)
//	public AppProp retrieveAppCode(String appCpde);
//	@Query(value="select APPCODE, Version from APPCODE where APPCODE=appCode and VERSION=Version", nativeQuery=true)
//	public AppProp retreiveAppProp(String appCode, String version);
	
	
}
