package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Category extends BaseEntity {
     
	@Column(name="categort_name" ,nullable = false)
	private String categoryName;
	private String description;
	
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Product> productList = new ArrayList<>();

	
	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}
    
	public void addProduct(Product product) {
		this.productList.add(product);
		product.setCategory(this);
	}
	
	public void deleteProduct(Product product) {
		this.productList.remove(product);
		product.setCategory(null);
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", description=" + description + "]";
	}
	
}

