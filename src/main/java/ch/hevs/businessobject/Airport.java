package ch.hevs.businessobject;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
@Entity
public class Airport {

	
	//VARIABLE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idAirport;
	private String airportCode;
	private String country;
	private String location;
	
	//CONSTRUCTOR
	public Airport()
	{
		
	}
	
	public Airport(String airportCode, String country, String location)
	{
		this.airportCode=airportCode;
		this.country=country;
		this.location=location;
	}

	
	
	//GETTER-SETTER
	public Long getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(Long idAirport) {
		this.idAirport = idAirport;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
}
