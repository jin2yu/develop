package kr.seoul.mandoo.dfMgr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Keyword {

	@javax.persistence.Id @GeneratedValue
	public Long Id;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public Member member;
	
	public String keyword;
}
