package com.niks.hibernateTest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Channel {
	@Id
	@GeneratedValue
	@Column(name="channelId")
	private int channelId;
	private String channelName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Package pckage;
	
	public Package getPckage() {
		return pckage;
	}
	public void setPckage(Package pckage) {
		this.pckage = pckage;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
}
