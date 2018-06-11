package com.vehicle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle implements java.io.Serializable {

	private static final long serialVersionUID = 4910225916550731446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "make", length = 50)
	private String make;

	@Column(name = "model", length = 50)
	private String model;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "type", length = 50)
	private String type;

	@Column(name = "seating_capacity", length = 50)
	private int seatingCapacity;

	@Column(name = "top_speed", length = 50)
	private double topSpeed;

	@Column(name = "payloadCapacity", length = 50)
	private double payloadCapacity;

	public Vehicle() {
	}

	public Vehicle(Long id, String make, String model, String name, String type, int seatingCapacity, double topSpeed,
			double payloadCapacity) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.name = name;
		this.type = type;
		this.seatingCapacity = seatingCapacity;
		this.topSpeed = topSpeed;
		this.payloadCapacity = payloadCapacity;
	}

	public Vehicle(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}

	public double getPayloadCapacity() {
		return payloadCapacity;
	}

	public void setPayloadCapacity(double payloadCapacity) {
		this.payloadCapacity = payloadCapacity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		Vehicle toCompare = (Vehicle) obj;
		return id.equals(toCompare.id);
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

}
