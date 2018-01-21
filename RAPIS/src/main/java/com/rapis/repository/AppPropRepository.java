package main.java.com.rapis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.rapis.domain.AppProp;

@Repository
public interface AppPropRepository extends JpaRepository<AppProp, String>{
	//LOGGER.info("Service------------");
	@Modifying
	@Query(value="insert into APPPROP (APPCODE,VERSION) values(:appCode,:version)", nativeQuery=true)
	@Transactional
	void save(@Param("appCode") String appCode, @Param("version") String version);
//	@Query(value="select * from APPCODE where APPCODE=appCode", nativeQuery=true)
//	public AppProp retrieveAppCode(String appCpde);
//	@Query(value="select APPCODE, Version from APPCODE where APPCODE=appCode and VERSION=Version", nativeQuery=true)
//	public AppProp retreiveAppProp(String appCode, String version);
	
	
}
