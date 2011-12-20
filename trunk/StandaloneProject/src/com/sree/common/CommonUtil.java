/**
 * 
 */
package com.sree.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PropertyResourceBundle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author srinivasr
 *
 */
public class CommonUtil {
	
	private static ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml");
	
	public static Object getBean(String beanName){
		return ac.getBean(beanName);
	}
	
	public static PropertyResourceBundle getBundle(String fileName){
		return (PropertyResourceBundle)PropertyResourceBundle.getBundle(fileName);
	}
	
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		return dateFormat.format(date);
	}
}
