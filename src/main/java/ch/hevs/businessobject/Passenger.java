package ch.hevs.businessobject;

import java.util.*;

import javax.persistence.*;

@Entity
public class Passenger {

	//VARIABLE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String firstname;
	
	//RELATION
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Flight> flights;
	
	
	//CONSTRUCTOR
	public Passenger()
	{
		//this.flights = new HashSet<Flight>();
	}
	
	public Passenger(String name, String firstname)
	{
		this.name=name;
		this.firstname=firstname;
		this.flights = new HashSet<Flight>(); //Ajouter au passer une liste de vol
		
	}

	
	//GETTER-SETTER
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}


	public void addFlight(Flight f)
	{
		flights.add(f);
		f.addPassenger(this);
	}
	

	
}
