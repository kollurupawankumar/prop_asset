package com.embassy.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propertyId;
	private String propertyName;
	private String propertyDescription;
	private int isDeleted;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimestamp;
	private int createdUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedTimestamp;
	private int lastModifiedUser;
	private double lat;
	private double lot;
	private int parentPropertyId;


	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public int getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(int createdUser) {
		this.createdUser = createdUser;
	}

	public Date getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(Date lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	public int getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(int lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLot() {
		return lot;
	}

	public void setLot(double lot) {
		this.lot = lot;
	}

	public int getParentPropertyId() {
		return parentPropertyId;
	}

	public void setParentPropertyId(int parentPropertyId) {
		this.parentPropertyId = parentPropertyId;
	}

	

}
