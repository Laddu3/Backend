package com.mms.project1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String description;

private String status;

// Constructors, getters, and setters
}
