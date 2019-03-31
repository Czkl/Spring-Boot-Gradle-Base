package com.tw.simple.entity.base;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract String getPrimaryKey();
	
	public  String getTableName(){
		return this.getClass().getName();
	}
}
