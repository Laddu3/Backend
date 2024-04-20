package com.hcl.surabi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "admin_table")
public class Admin {

	@Id
	private long adminId;
	private String adminuserName;
	private String adminpassword;
}
