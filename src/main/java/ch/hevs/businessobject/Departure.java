package ch.hevs.businessobject;

import java.util.*;

import javax.persistence.*;

@Entity
public class Departure extends Airport {

	
	//VARIABLE
		private String flightDate;
		private String departureTime;


		//RELATION 
		@OneToMany(mappedBy ="departure", cascade = CascadeType.ALL)
		private Set<Flight> flights;
		
		//CONSTRUCTOR
		public Departure()
		{
			super();
			flights = new HashSet<Flight>();

		}

		public Departure(String airportCode, String country, String location, String flightDate, String departureTime)
		{
			super(airportCode,country,location);
			this.flightDate=flightDate;
			this.departureTime=departureTime;
			this.flights = new HashSet<Flight>();

		}

		
		//GETTER-SETTER
		public String getFlightDate() {
			return flightDate;
		}

		public void setFlightDate(String flightDate) {
			this.flightDate = flightDate;
		}

		public String getDepartureTime() {
			return departureTime;
		}

		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime;
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
			f.setDeparture(this);
			
		}
		 
	}
