package com.paigeruppel.trees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tree {

	@GeneratedValue
	@Id
	private Long id;

	private String family;
	private String genus;
	private String species;
	private String commonName;

	private String imageUrl;

	public Long getId() {
		return id;
	}

	public String getFamily() {
		return family;
	}

	public String getGenus() {
		return genus;
	}

	public String getSpecies() {
		return species;
	}

	public String getCommonName() {
		return commonName;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	public Boolean hasImageUrl() {
		return imageUrl != null;
	}

	private Tree() {
	}

	public Tree(String family, String genus, String species, String commonName) {
		this.family = family;
		this.genus = genus;
		this.species = species;
		this.commonName = commonName;
	}
	
	public Tree(String family, String genus, String species, String commonName, String imageUrl) {
		this(family, genus,  species, commonName);
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return family + ": " + genus + " " + species + " ";
	}
	
	public String buildBinomialName() {
		return genus + " " + species;
	}
	
	

}
