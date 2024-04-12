package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Privileges {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer previlegeId;
	private String previlegeName;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Roles> roles;

}
