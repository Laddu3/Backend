package com.hcl.surabi.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orderhistory_table")
public class MyOrderHistory {

	@Id
	private long order_id;
	private String userName;
	private String itemName;
	private int total_amt;
	private int plates;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

}