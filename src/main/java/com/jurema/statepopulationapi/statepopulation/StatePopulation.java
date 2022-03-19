package com.jurema.statepopulationapi.statepopulation;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class StatePopulation {
	@Id
	private Integer id;
	private String uf;
	@JsonProperty("populacao")
	private Integer population;
}
