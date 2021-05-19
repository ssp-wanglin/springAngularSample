package spring.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import spring.test.model.Account;


@RestController
public class HomeController {
	
	public HomeController() {}
	
	@RequestMapping(value = "/getAccounts/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
	public Account getAccountById(@PathVariable String id, HttpServletRequest request,HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
	       for(Cookie cookie : cookies){  
	            System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());  
	        }  
		List<Account> listA = this.getAccount();
		for (Account acc : listA) {
			if (acc.getId().equals(id)) {
				return acc;
			}
			
		}
		return null;
	}
	
	@RequestMapping("/showCookies")  
	public void showCookies(HttpServletRequest request,HttpServletResponse response ){  

	    Cookie[] cookies = request.getCookies();
	    if (null==cookies) {  
	        System.out.println("No cookie=========");
	    } else {  
	        for(Cookie cookie : cookies){  
	            System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue()+",url:"+ cookie.getPath());  
	        }  
	    }  
	}
	
	@RequestMapping(value = "/accounts", method=RequestMethod.GET, headers = "Accept=application/json")
	public List<Account> getAccounts(HttpServletRequest request){
		List<Account> listA = this.getAccount();
		
		Cookie[] cookies = request.getCookies();
	       for(Cookie cookie : cookies){  
	            System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());  
	        }
		return listA;
	}
	
	public List<Account> getAccount(){
		
		List<Account> listA  = new ArrayList<Account>();
		Account accountA = new Account();
		accountA.setId("001");
		accountA.setName("TOM");
		listA.add(accountA);
		
		Account accountB = new Account();
		accountB.setId("002");
		accountB.setName("BOB");
		listA.add(accountB);
		
		return listA;
	}

    // Angularで生成したhtmlファイルを呼び出す
    @RequestMapping("/")
    public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
    	return new ModelAndView("index");
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)  
    public String registPost() {  
        return "/home";  
    }

}