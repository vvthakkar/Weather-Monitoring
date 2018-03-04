package io.egen.SpringBootREST.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wind {

	@Id
	private String id;
	private float speed;
	private int  degree;
	
//	@OneToOne(mappedBy="wind")
//	private City city;
	
	public Wind() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

//	public City getCity() {
//		return city;
//	}
//
//	public void setCity(City city) {
//		this.city = city;
//	}


	
}
