package com.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class destination_list {
	
	
	@Column(nullable=false)
	@Id
	private String destination_id;
	
	@Column(nullable=false)
	private String destination;


	
	
	
	@Override
	public String toString() {
		return "destination_list [destination_id=" + destination_id + ", destination=" + destination + "]";
	}

	public String getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(String destination_id) {
		this.destination_id = destination_id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public destination_list(String destination_id, String destination) {
		super();
		this.destination_id = destination_id;
		this.destination = destination;
	}

	public destination_list() {
		super();
	}
	
	
	

}
