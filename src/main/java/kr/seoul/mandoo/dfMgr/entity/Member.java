package kr.seoul.mandoo.dfMgr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Member {

	@javax.persistence.Id @GeneratedValue
	public Long Id;
	
	public String userId;
	public String firstname;
	public String lastname;
	public String email;
	public String password;
	
}
