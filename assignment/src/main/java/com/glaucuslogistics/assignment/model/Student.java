package com.glaucuslogistics.assignment.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO File for storing entity model Student,
 * having attributes id, name and score,
 * as JSON Object
 * @author Shravan
 *
 */

@XmlRootElement
public class Student {
	
	private long id;
	private String name;
	private long score;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	
}
