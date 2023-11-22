package ar.com.educacionit.connectors.covid.dto;

import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "date", "states", "positive", "negative", "pending",
"death", "hospitalized", "totalTestResults","recovered", "total",})

@JsonIgnoreProperties(value = { "inIcuCurrently", "inIcuCumulative", "onVentilatorCurrently", "onVentilatorCumulative",
		"hospitalizedCurrently", "hospitalizedCumulative","dateChecked", "lastModified", "posNeg", "deathIncrease", "hospitalizedIncrease", 
		"negativeIncrease","positiveIncrease", "totalTestResultsIncrease", "hash" ,"total","recovered" })

@Generated("jsonschema2pojo")
public class CovidDTO {

	@JsonProperty("date")
	private Integer date;
	@JsonProperty("states")
	private Integer states;
	@JsonProperty("positive")
	private Integer positive;
	@JsonProperty("negative")
	private Integer negative;
	@JsonProperty("pending")
	private Integer pending;

	@JsonProperty("death")
	private Integer death;
	@JsonProperty("hospitalized")
	private Integer hospitalized;
	@JsonProperty("totalTestResults")
	private Integer totalTestResults;
		
	@JsonProperty("date")
	public Integer getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(Integer date) {
		this.date = date;
	}

	@JsonProperty("states")
	public Integer getStates() {
		return states;
	}

	@JsonProperty("states")
	public void setStates(Integer states) {
		this.states = states;
	}

	@JsonProperty("positive")
	public Integer getPositive() {
		return positive;
	}

	@JsonProperty("positive")
	public void setPositive(Integer positive) {
		this.positive = positive;
	}

	@JsonProperty("negative")
	public Integer getNegative() {
		return negative;
	}

	@JsonProperty("negative")
	public void setNegative(Integer negative) {
		this.negative = negative;
	}

	@JsonProperty("pending")
	public Integer getPending() {
		return pending;
	}

	@JsonProperty("pending")
	public void setPending(Integer pending) {
		this.pending = pending;
	}

	@JsonProperty("death")
	public Integer getDeath() {
		return death;
	}

	@JsonProperty("death")
	public void setDeath(Integer death) {
		this.death = death;
	}

	@JsonProperty("hospitalized")
	public Integer getHospitalized() {
		return hospitalized;
	}

	@JsonProperty("hospitalized")
	public void setHospitalized(Integer hospitalized) {
		this.hospitalized = hospitalized;
	}

	@JsonProperty("totalTestResults")
	public Integer getTotalTestResults() {
		return totalTestResults;
	}

	@JsonProperty("totalTestResults")
	public void setTotalTestResults(Integer totalTestResults) {
		this.totalTestResults = totalTestResults;
	}

}
