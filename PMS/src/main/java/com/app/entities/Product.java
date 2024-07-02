package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Product extends BaseEntity {
	@Column(name="product_name" ,length=25)
    private String productName;
    private double price;
    @Column(name="available_quantity")
    private int availableQuantity;
    @ManyToOne
    @JoinColumn(name="category_id" , nullable = false)
    private Category category;
    @ManyToOne(fetch=FetchType.LAZY )	
	@JoinColumn(name="author_id",nullable = false)
	private User user;
    
	public Product(String productName, double price, int availableQuantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", availableQuantity=" + availableQuantity+"]";
	}


    
}
