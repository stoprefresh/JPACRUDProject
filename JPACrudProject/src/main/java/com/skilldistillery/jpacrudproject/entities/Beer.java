package com.skilldistillery.jpacrudproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String brewery;
		
	private String type;
	
	private String description;
	
	private String notes;
	
	@Column(name="abv")
	private double alcoholByVolume;

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

	public String getBrewery() {
		return brewery;
	}

	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}

	public String getTypeOf() {
		return type;
	}

	public void setTypeOf(String typeOf) {
		this.type = typeOf;
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
		return alcoholByVolume;
	}

	public void setAlcoholByVolume(double alcoholByVolume) {
		this.alcoholByVolume = alcoholByVolume;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Beer [id=").append(id).append(", name=").append(name).append(", brewery=").append(brewery)
				.append(", type=").append(type).append(", description=")
				.append(description).append(", notes=").append(notes).append(", alcoholByVolume=")
				.append(alcoholByVolume).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(alcoholByVolume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((brewery == null) ? 0 : brewery.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (Double.doubleToLongBits(alcoholByVolume) != Double.doubleToLongBits(other.alcoholByVolume))
			return false;
		if (brewery == null) {
			if (other.brewery != null)
				return false;
		} else if (!brewery.equals(other.brewery))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
