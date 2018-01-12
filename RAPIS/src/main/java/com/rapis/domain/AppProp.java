package main.java.com.rapis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AppProp")
public class AppProp {
	@Id
	@Column
	private String appCode;
	@Column
	private String version;
	public AppProp() {
		
	}
	public AppProp(String appCode, String version) {
		this.appCode=appCode;
		this.version=version;
	}
	public String getCode() {
		return appCode;
	}

	public void setCode(String appCode) {
		this.appCode = appCode;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "[appCode: "+appCode+" version: "+version +"]";
	}
}
