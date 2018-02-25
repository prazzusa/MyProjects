package com.puspa.pizza.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Topping {
	private Long id;
	private String description;
	private Double price;
	private Set<Pizza> pizzas = new HashSet<>();
	
	@Id
	@GeneratedValue
	@Column(name="topping_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/*here,we dont have to use mapped by
	mappedby is used to specify which end is the owning side, and for this relationshp
	we used mapped by in Pizza*/
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
		@JoinTable(name="pizza_topping",catalog="pizzadelivarysystem",
			joinColumns=@JoinColumn(name="topping_id"),
			inverseJoinColumns=@JoinColumn(name="pizza_id"))
	public Set<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	

}
