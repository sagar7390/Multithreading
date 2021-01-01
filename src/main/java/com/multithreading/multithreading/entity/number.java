package com.multithreading.multithreading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="increment_multithreading")
public class number {

	@Id
	@Column(name="number")
	private int number;

	@Override
	public String toString() {
		return "number is :"+number;
	}
	
	
}
