package com.embassy.dao.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int assetId;
	private String assetName;
	private String assetModel;
	private String assetMake;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfInstallation;
	private double quantity;
	@Temporal(TemporalType.TIMESTAMP)
	private Date warranty;
	private int action;
	private int isDeleted;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimestamp;
	private int createdUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	private int lastModifiedUser;
	private int parentAssetId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "property_id")
	private Property property;

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}

	public String getAssetMake() {
		return assetMake;
	}

	public void setAssetMake(String assetMake) {
		this.assetMake = assetMake;
	}

	public Date getDateOfInstallation() {
		return dateOfInstallation;
	}

	public void setDateOfInstallation(Date dateOfInstallation) {
		this.dateOfInstallation = dateOfInstallation;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Date getWarranty() {
		return warranty;
	}

	public void setWarranty(Date warranty) {
		this.warranty = warranty;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
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

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(int lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public int getParentAssetId() {
		return parentAssetId;
	}

	public void setParentAssetId(int parentAssetId) {
		this.parentAssetId = parentAssetId;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

}
