package com.puspa.pizza.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author PuspaTara
 *
 */
/**
 * @author PuspaTara
 *
 */
@Entity
@Table(name="orders")
public class Order {
	private long id;
	private Customer customer;
	private Set<Pizza> pizzas = new HashSet<>();
	private Double finalPrice;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
/**
 * Here Customer is parent and Order is child
	So, putting ManyToOne on child entity
 */
	@ManyToOne
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * Here Order is parent, and Pizza is child
		So, OneToMany on parent entity
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="order")
	public Set<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	public Double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	
}
