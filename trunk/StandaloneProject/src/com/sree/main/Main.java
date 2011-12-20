package com.sree.main;

import org.apache.log4j.Logger;

import com.sree.common.CommonUtil;
import com.sree.service.BaseService;
import com.sree.service.IBaseService;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		
		IBaseService baseService = (BaseService) CommonUtil.getBean("baseService");
		
		/*List<AppUser> ls = baseService.find("getUsers", AppUser.class, new Object[]{"USER_ID", "USER_NAME", "ACCOUNT_NON_EXPIRED"});
		
		System.out.println(ls.size());
		
		for(AppUser user: ls){
			System.out.println(user.getUsername());
			
			System.out.println(user.getId());
			
			System.out.println(user.getAccountNonExpired());
		}*/
		
	}


}
