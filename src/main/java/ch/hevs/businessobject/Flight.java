package ch.hevs.businessobject;

import java.util.*;

import javax.persistence.*;

@Entity
public class Flight {
	
	//VARIABLE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String company;
	private String flightnbr;
	private int capacity;
	
	//RELATION
	@ManyToMany(cascade = CascadeType.ALL, mappedBy ="flights")
	private Set<Passenger> passengers;
	
	@ManyToOne()
	private Departure departure;
	
	@ManyToOne()
	private Destination destination;
	
	//CONSTRUCTOR
	public Flight()
	{
		//this.passengers = new HashSet<Passenger>();

	}
	
	public Flight(String company, String flightNbr, int capacite)
	{
		this.company=company;
		this.flightnbr=flightNbr;
		this.capacity=capacite;
		this.passengers = new HashSet<Passenger>();
	}

	
	//GETTER-SETTER
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFlightnbr() {
		return flightnbr;
	}

	public void setFlightnbr(String flightNbr) {
		this.flightnbr = flightNbr;
	}

	public int getCapacite() {
		return capacity;
	}

	public void setCapacite(int capacite) {
		this.capacity = capacite;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Departure getDeparture() {
		return departure;
	}

	public void setDeparture(Departure departure) {
		this.departure = departure;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public void addPassenger(Passenger p)
	{
		passengers.add(p);
	}
	
	
	

}
