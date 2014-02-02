package sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sample.controller.UserController.UserModel;

@Component
public class UserService {
	@Autowired
	SqlManager sqlManager;

	@Transactional
	public List<Map> findAll() {
		return sqlManager.getResultList(Map.class, new ClasspathSqlResource("select-user.sql"));
	}

	@Transactional
	public Map findByUsername(String username) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		return sqlManager.getSingleResult(Map.class, new ClasspathSqlResource("select-user.sql"), params);
	}

	@Transactional
	public void createUser(UserModel userModel){
		Users user = new Users();
		user.username = userModel.getUsername();
		user.mailaddress = userModel.getMailaddress();
		sqlManager.insertEntity(user);
	}

	@Transactional
	public void updateUser(UserModel userModel){
		Users user = new Users();
		user.username = userModel.getUsername();
		user.mailaddress = userModel.getMailaddress();
		sqlManager.updateEntity(user);
	}

	@Transactional
	public void deleteUser(UserModel userModel){
		Users user = new Users();
		user.username = userModel.getUsername();
		sqlManager.deleteEntity(user);
	}

}