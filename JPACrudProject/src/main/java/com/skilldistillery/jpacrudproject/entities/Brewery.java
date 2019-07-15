package com.skilldistillery.jpacrudproject.entities;

import java.util.*;

import javax.persistence.*;

@Entity
public class Brewery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String city;
	
	private String state;
	
	@Column(name="year_established")
	private String yearEstablished;
	
	private String country;
	
	private String address;
	
	private String notes;
	
	private String website;
	
	@OneToMany(mappedBy = "brewery")
	private List<Beer> beers;

	public Brewery() {}
	
	public Brewery(String ...info) {
		setName(info[0]);
		if(info[1] != null) {setCity(info[1]);}
		if(info[2] != null) {setState(info[2]);}
		if(info[3] != null) {setYearEstablished(info[3]);}
		if(info[4] != null) {setCountry(info[4]);}
		if(info[5] != null) {setAddress(info[5]);}
		if(info[6] != null) {setNotes(info[6]);}
		if(info[7] != null) {setWebsite(info[7]);}
	}
	
	public void addBeer(Beer beer) {
		if (beers == null) {
			beers = new ArrayList<>();
		}
		if (!beers.contains(beer)) {
			beers.add(beer);
			beer.setBrewery(this);
		}
	}

	public void removeBeer(Beer beer) {
		if (beers != null && beers.contains(beer)) {
			beers.remove(beer);
			beer.setBrewery(null);
		}
	}
	
	public List<Beer> getBeers() {
		return beers;
	}

	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Brewery [id=").append(id).append(", name=").append(name).append(", city=").append(city)
				.append(", state=").append(state).append(", yearEstablished=").append(yearEstablished)
				.append(", country=").append(country).append(", address=").append(address).append(", notes=")
				.append(notes).append(", website=").append(website).append(", beer=").append(beers).append("]");
		return builder.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getYearEstablished() {
		return yearEstablished;
	}

	public void setYearEstablished(String yearEstablished) {
		this.yearEstablished = yearEstablished;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brewery other = (Brewery) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
