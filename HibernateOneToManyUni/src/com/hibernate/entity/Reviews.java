package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Reviews {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String commnet;
	
	public Reviews() {
		
	}

	
	public Reviews(String commnet) {
		super();
		this.commnet = commnet;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommnet() {
		return commnet;
	}

	public void setCommnet(String commnet) {
		this.commnet = commnet;
	}


	public Reviews(int id, String commnet) {
		super();
		this.id = id;
		this.commnet = commnet;
	}

}
