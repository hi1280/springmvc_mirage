package sample.service;

import jp.sf.amateras.mirage.annotation.PrimaryKey;
import jp.sf.amateras.mirage.annotation.PrimaryKey.GenerationType;

public class Users{

	@PrimaryKey(generationType=GenerationType.APPLICATION)
	public String username;

	public String mailaddress;

}
