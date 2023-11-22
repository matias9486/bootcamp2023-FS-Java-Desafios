package ar.com.educacionit.domain;


public class Pokemon extends Entity{
	private Integer id;	
	private String name;	
	private Integer height;	
	private Integer weight;
	
	public Pokemon(Integer id, String name, Integer height, Integer weight) {		
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return id + "- " + name + ".\tAltura=" + height + ".\tPeso=" + weight;
	}
	
	

}
