package spring.test.service;

import java.util.UUID;

import javax.servlet.http.Cookie;

import org.springframework.util.DigestUtils;

import spring.test.model.Account;

public class UserService {

	
    public void saveUser(Account account) {
        //1.获取明文
        String password = account.getPassword();
        //2.利用Spring的工具API进行加密操作
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        account.setPassword(account.getPassword());
    
    }
    
    public String doLogin(Account account) {
    	
    	String password = DigestUtils.md5DigestAsHex(account.getPassword().getBytes());
    	
    	String ticket = UUID.randomUUID().toString().replace("-", "");

    	
    	Cookie cookie = new Cookie("JT_TICKET",ticket);
    	
    	return ticket;
    	
    }
}
