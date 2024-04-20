package com.hcl.surabi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
//Lombok
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "mycart_table")
public class Cart {
	@Id
	private long Itemid;

	private String itemName;
	private int price;
}
