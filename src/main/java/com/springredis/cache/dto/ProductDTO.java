package com.springredis.cache.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ITEMS")
public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", columnDefinition = "INT")
	private Integer productId;
	
	@Column(name = "name", columnDefinition = "VARCHAR")
	private String productName;
	
	@Column(name = "description", columnDefinition = "VARCHAR")
	private String productDescription;
	
	@Column(name = "type", columnDefinition = "VARCHAR")
	private String type;
	
	@Column(name = "price", columnDefinition = "INT")
	private Integer price;
	
	@Column(name = "qty", columnDefinition = "INT")
	private Integer quantity;
	
	@Column(name = "version", columnDefinition = "INT")
	private Integer version;

}
