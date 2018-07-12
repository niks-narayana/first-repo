package com.niks.hibernateTest.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Package {
	@Id
	@GeneratedValue
	private int packageId;
	private String packageName;
	
	@OneToMany(cascade = CascadeType.ALL)
	//@JoinTable(name = "package_channel", joinColumns = { @JoinColumn(name = "packageId") }, inverseJoinColumns = { @JoinColumn(name = "channelId") })
	private List<Channel> channels = new ArrayList<Channel>();
	
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
}
