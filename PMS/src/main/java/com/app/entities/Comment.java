package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comments",uniqueConstraints = 
@UniqueConstraint(columnNames = {"commenter_id","product_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Comment extends BaseEntity {
  
	@Column(name = "comment_text", length = 100)
	private String commentText;
	private int rating;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id",nullable = false)
	private Product product;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="commenter_id",nullable = false)
	private User commenter;

	
	
	@Override
	public String toString() {
		return "Comment [commentText=" + commentText + ", rating=" + rating +"]";
	}



	public Comment(String commentText, int rating) {
		super();
		this.commentText = commentText;
		this.rating = rating;
	}
	
}
