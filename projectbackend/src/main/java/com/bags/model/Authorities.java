package com.bags.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.bags.model.User;
//Authorization
@Entity
public class Authorities {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@OneToOne
private User user;
private String role;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

}