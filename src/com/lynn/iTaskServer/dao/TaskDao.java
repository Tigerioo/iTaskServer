package com.lynn.iTaskServer.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.lynn.iTaskServer.model.TagModel;
import com.newland.bg.commontools.db.JDBCUtil;
import com.newland.bg.commontools.exception.NewlandSQLException;

public class TaskDao {
	
	private Logger logger = Logger.getLogger(TaskDao.class);
	
	private JDBCUtil jdbc = new JDBCUtil();
	
	public void saveTag(TagModel tag, int user_id){
		String sql = "insert into iTask_tag(id, content, create_time, user_id) values(?, ?, DATE_FORMAT(?,'%Y-%m-%d %H:%i:%s'), ?)";
		try {
			
			jdbc.execute(sql, new Object[]{tag.getId(), tag.getContent(), dateFormat(tag.getCreate_time()), user_id});
		} catch (NewlandSQLException e) {
			logger.error(e.toString(), e);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}
	
	private String dateFormat(Date date){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
}
