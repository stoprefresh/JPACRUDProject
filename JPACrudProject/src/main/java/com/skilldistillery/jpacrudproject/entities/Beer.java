package com.skilldistillery.jpacrudproject.entities;

import javax.persistence.*;

@Entity
public class Beer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String type;
	
	private double abv;
	
	private String description;
	
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="brewery_id")
	private Brewery brewery;
	
	public Beer() {}

	public Beer(double abv, String ...info) {
		setAbv(abv);
		setName(info[0]);
		setType(info[1]);
		if(info[2] != null){setDescription(info[2]);}
		if(info[3] != null){setNotes(info[3]);}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Beer [id=").append(id).append(", name=").append(name).append(", type=").append(type)
				.append(", abv=").append(abv).append(", description=").append(description).append(", notes=")
				.append(notes).append(", brewery=").append(brewery.getName()).append("]");
		return builder.toString();
	}

	public Brewery getBrewery() {
		return brewery;
	}

	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPersonalNotes() {
		return notes;
	}

	public void setPersonalNotes(String personalNotes) {
		this.notes = personalNotes;
	}

	public double getAlcoholByVolume() {
		return abv;
	}

	public void setAlcoholByVolume(double alcoholByVolume) {
		this.abv = alcoholByVolume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Beer other = (Beer) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
