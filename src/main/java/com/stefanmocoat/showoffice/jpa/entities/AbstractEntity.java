package com.stefanmocoat.showoffice.jpa.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@javax.persistence.MappedSuperclass
public abstract class AbstractEntity {

	@Id
	@GeneratedValue
	private long id;

	@Version
	private long version;

	private Date insertTime;

	private Date updateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@PrePersist
	protected void beforeInsert() {
		insertTime = new Date();
	}
	
	@PreUpdate
	protected void beforeUpdate() {
		updateTime = new Date();
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
