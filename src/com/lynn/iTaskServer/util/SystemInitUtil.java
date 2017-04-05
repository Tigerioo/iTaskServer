package com.lynn.iTaskServer.util;

import java.util.Properties;

/**
 * <p>Title: com.newland.appmonitor.util.SystemInitUtil.java</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2001-2013 Newland SoftWare Company</p>
 *
 * <p>Company: Newland SoftWare Company</p>
 *
 * @author Lewis.Lynn
 *
 * @version 1.0 CreateTime��2014��11��14�� ����6:53:15
 */

public class SystemInitUtil {
	
	public static String log4jFilePath ;
	public static String m_appConfPath ;
	public static String resultFilePath;
	public static String springFilePath;
	
	static {
		Properties pros = System.getProperties();
		String dir = (String)pros.get("user.dir");
		String sepa = (String)pros.get("file.separator");
		if(dir.endsWith("bin")){
			log4jFilePath = "../conf" + sepa + "log4j.properties";
			m_appConfPath = "../conf" + sepa + "application.xml";
			springFilePath = "../conf" + sepa + "spring-net.xml";
			resultFilePath = "../result" + sepa;
		}else {
			log4jFilePath = sepa + dir + sepa + "conf" + sepa + "log4j.properties";
			m_appConfPath = sepa + dir + sepa + "conf" + sepa + "application.xml";
			springFilePath = sepa + dir + sepa + "conf" + sepa + "spring-net.xml";
			resultFilePath = sepa + dir + sepa + "result" + sepa ;
		}
		
	}
	
}
