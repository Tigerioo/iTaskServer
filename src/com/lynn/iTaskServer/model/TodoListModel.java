/**
 * 
 */
package com.lynn.iTaskServer.model;

/**
 * <p>
 * Title: com.superman.plancalendar.model.TodoListModel.java
 * </p>
 * 
 * <p>
 * Description: 任务计划的Model类
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2001-2013 Newland SoftWare Company
 * </p>
 * 
 * <p>
 * Company: Newland SoftWare Company
 * </p>
 * 
 * @author Lewis.Lynn
 * 
 * @version 1.0 CreateTime：2014-6-3 下午2:03:38
 */

public class TodoListModel {

	private long id;
	private long pid;
	private String content;
	private int repeat_type;
	private long dead_time;
	private int is_remind;
	private long tag_id;
	private int isComplete;
	private long create_time;
	private String week;//add since v0.0.9.9.1
	private long completeTimeCount;//add since v0.0.9.9.6
	private long complete_time_count_left;//add since v0.0.9.9.6
	private int is_task_complete;//add since v0.0.9.9.7
	private long repeat_id;//add since v0.0.9.9.7

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRepeat_type() {
		return repeat_type;
	}

	public void setRepeat_type(int repeat_type) {
		this.repeat_type = repeat_type;
	}

	public long getDead_time() {
		return dead_time;
	}

	public void setDead_time(long dead_time) {
		this.dead_time = dead_time;
	}

	public int getIs_remind() {
		return is_remind;
	}

	public void setIs_remind(int is_remind) {
		this.is_remind = is_remind;
	}

	public long getTag_id() {
		return tag_id;
	}

	public void setTag_id(long tag_id) {
		this.tag_id = tag_id;
	}

	public int getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(int isComplete) {
		this.isComplete = isComplete;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public long getCompleteTimeCount() {
		return completeTimeCount;
	}

	public void setCompleteTimeCount(long completeTimeCount) {
		this.completeTimeCount = completeTimeCount;
	}

	public long getComplete_time_count_left() {
		return complete_time_count_left;
	}

	public void setComplete_time_count_left(long complete_time_count_left) {
		this.complete_time_count_left = complete_time_count_left;
	}

	public int getIs_task_complete() {
		return is_task_complete;
	}

	public void setIs_task_complete(int is_task_complete) {
		this.is_task_complete = is_task_complete;
	}

	public long getRepeat_id() {
		return repeat_id;
	}

	public void setRepeat_id(long repeat_id) {
		this.repeat_id = repeat_id;
	}
	
}
