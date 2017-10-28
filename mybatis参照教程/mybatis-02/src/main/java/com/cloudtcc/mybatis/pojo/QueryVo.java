package com.cloudtcc.mybatis.pojo;

import java.util.List;

public class QueryVo {
	private  User user;
	private List<Integer> ids;
	private Integer[] idArr;
	
	public Integer[] getIdArr() {
		return idArr;
	}

	public void setIdArr(Integer[] idArr) {
		this.idArr = idArr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
}
