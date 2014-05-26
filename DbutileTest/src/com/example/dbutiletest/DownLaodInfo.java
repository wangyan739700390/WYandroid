package com.example.dbutiletest;

import java.io.Serializable;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Transient;

public class DownLaodInfo implements Serializable {
	String id ,title,content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


  
}
