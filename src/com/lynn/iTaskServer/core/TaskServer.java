package com.lynn.iTaskServer.core;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.dom4j.Document;
import org.dom4j.Element;

import com.lynn.iTaskServer.dao.TaskDao;
import com.lynn.iTaskServer.model.TagModel;
import com.lynn.iTaskServer.util.SystemInitUtil;
import com.newland.bg.commontools.db.DataBaseConfigurator;
import com.newland.bg.commontools.db.JDBCUtil;
import com.newland.bg.commontools.xml.CommonXml;

/**
 * 1. 加载xml数据备份文件
 * 2. 解析xml入list中
 * 3. 将list中的数据入库
 * @author lynn
 *
 */
public class TaskServer {
	
	private Logger logger = Logger.getLogger(TaskServer.class);
	private TaskDao dao = new TaskDao();
	
	public void task(int user_id){
		List<TagModel> tags = analysisXmlFile("./file/tag.xml");
		if(tags == null || tags.size() == 0) return;
		for (TagModel tag : tags) {
			logger.info("[id=" + tag.getId() + ",content=" + tag.getContent() + ",create_time=" + tag.getCreate_time() + "]");
			dao.saveTag(tag, user_id);
		}
	}
	
	
	/**
	 * analysis the xml file, save result as TagModel to List for return
	 * @param file
	 * @return
	 */
	public List<TagModel> analysisXmlFile(String fileName){
		List<TagModel> tags = new ArrayList<TagModel>();
		try {
			Document document = CommonXml.getDocumentByFileName(fileName);
			Element root = document.getRootElement();
			Iterator iter = root.elementIterator();
			while(iter.hasNext()){
				Element rcd = (Element)iter.next();
				TagModel model = new TagModel();
				try {
					model.setId(Long.parseLong(rcd.element("id").getStringValue()));
					model.setContent(rcd.element("content").getStringValue());
					Date date = new Date();
					date.setTime(Long.parseLong(rcd.element("create_time").getStringValue()));
					model.setCreate_time(date);
				} catch (NumberFormatException e) {
					logger.error(e.toString(), e);
				}
				tags.add(model);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return tags;
	}
	
	public static void main(String[] args) {
		PropertyConfigurator.configure(SystemInitUtil.log4jFilePath);
		DataBaseConfigurator.loadConfig(SystemInitUtil.m_appConfPath);
		TaskServer task = new TaskServer();
		task.task(1);
	}
}
