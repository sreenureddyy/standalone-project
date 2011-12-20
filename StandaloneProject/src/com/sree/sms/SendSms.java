/**
 * 
 */
package com.sree.sms;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

/**
 * @author srinivasr
 * 
 */
public class SendSms {
	public static void main(String[] args) {
		String username = "9886919190";
		String password = "trinay";
		
		String to = "9742061729";
		
		String message = "Happy new year in advance... :)...";
		
		try {
			if(message.length()<140){
				sendSMS(username, password, to, message, 0);
			}else{
				System.out.println("Message length is greater than 140 chars...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String sendSMS(String uid, String pwd, String mob, String msg, int i)
			throws IOException {
		HttpConnection httpConn = null;
		String url = "http://demo.samplephpcodes.com/sms/way2sms.php?uid="+ uid + "&pwd=" + pwd;
		InputStream is = null;
		//OutputStream os = null;
		String out = "";
		url = url + "&phone=" + mob + "&msg=" + urlEncode(msg);
		try {
			httpConn = (HttpConnection) Connector.open(url);

			httpConn.setRequestMethod("GET");
			httpConn.setRequestProperty("User-Agent", "Profile/MIDP-1.0 Confirguration/CLDC-1.0");

			int respCode = httpConn.getResponseCode();
			if (respCode == 200) {
				StringBuffer sb = new StringBuffer();
				is = httpConn.openDataInputStream();
				int chr;
				while ((chr = is.read()) != -1) {
					sb.append((char) chr);
				}

				System.out.println(i+")"+" Status : " + sb.toString() +" to "+mob);

				out = sb.toString();
			} else {
				System.out.println("Error in opening HTTP Connection. Error#"+ respCode);
			}
		} finally {
			if (is != null)
				is.close();
			
			if (httpConn != null)
				httpConn.close();
		}
		return out;
	}

	public static String urlEncode(String s) {
		try {
			if (s == null) {
				return s;
			}
			StringBuffer sb = new StringBuffer(100);

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (((c >= '0') && (c <= '9')) || ((c >= 'A') && (c <= 'Z'))
						|| ((c >= 'a') && (c <= 'z'))) {
					sb.append(c);
				} else if (c > '\017')
					sb.append("%" + Integer.toHexString(c));
				else {
					sb.append("%0" + Integer.toHexString(c));
				}
			}

			return sb.toString();
		} catch (Exception ex) {
			System.out.println("Exception, URLencode string is " + s);
		}
		return null;
	}

}
