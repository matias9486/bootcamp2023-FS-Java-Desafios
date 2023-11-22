package ar.com.educacionit.domain;

public class Covid extends Entity{
	
	private Integer date;	
	private Integer states;	
	private Integer positive;	
	private Integer negative;	
	private Integer pending;
	private Integer death;	
	private Integer hospitalized;	
	private Integer totalTestResults;
	
	public Covid(Integer date, Integer states, Integer positive, Integer negative, Integer pending, Integer death,
			Integer hospitalized, Integer totalTestResults) {		
		this.date = date;
		this.states = states;
		this.positive = positive;
		this.negative = negative;
		this.pending = pending;
		this.death = death;
		this.hospitalized = hospitalized;
		this.totalTestResults = totalTestResults;
	}
	
	public Covid(Long id, Integer date, Integer states, Integer positive, Integer negative, Integer pending, Integer death,
			Integer hospitalized, Integer totalTestResults) {
		this.id = id;
		this.date = date;
		this.states = states;
		this.positive = positive;
		this.negative = negative;
		this.pending = pending;
		this.death = death;
		this.hospitalized = hospitalized;
		this.totalTestResults = totalTestResults;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Integer getStates() {
		return states;
	}

	public void setStates(Integer states) {
		this.states = states;
	}

	public Integer getPositive() {
		return positive;
	}

	public void setPositive(Integer positive) {
		this.positive = positive;
	}

	public Integer getNegative() {
		return negative;
	}

	public void setNegative(Integer negative) {
		this.negative = negative;
	}

	public Integer getPending() {
		return pending;
	}

	public void setPending(Integer pending) {
		this.pending = pending;
	}

	public Integer getDeath() {
		return death;
	}

	public void setDeath(Integer death) {
		this.death = death;
	}

	public Integer getHospitalized() {
		return hospitalized;
	}

	public void setHospitalized(Integer hospitalized) {
		this.hospitalized = hospitalized;
	}

	public Integer getTotalTestResults() {
		return totalTestResults;
	}

	public void setTotalTestResults(Integer totalTestResults) {
		this.totalTestResults = totalTestResults;
	}

	@Override
	public String toString() {
		return "Covid [date=" + date + ", states=" + states + ", positive=" + positive + ", negative=" + negative
				+ ", pending=" + pending + ", death=" + death + ", hospitalized=" + hospitalized + ", totalTestResults="
				+ totalTestResults + "]";
	}	
}
