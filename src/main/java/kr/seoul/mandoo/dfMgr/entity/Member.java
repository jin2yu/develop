package kr.seoul.mandoo.dfMgr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Member {

	@javax.persistence.Id
	@Column(name="USER_ID")
	public String id;
	
	public String firstname;
	public String lastname;
	public String email;
	public String password;
	
}
