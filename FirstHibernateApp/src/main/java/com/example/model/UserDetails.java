package com.example.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	/*@Embedded
	private Address address;*/
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilo-gen", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters={
					@Parameter(name = "sequence_name", value = "hilo_seqeunce"),
					@Parameter(name = "initial_value", value = "1"),
					@Parameter(name = "increment_size", value = "3"),
					@Parameter(name = "optimizer", value = "hilo")})
	@CollectionId(columns={@Column(name="ADDRESS_ID")}, generator="hilo-gen", type=@Type(type="long"))
	private Collection<Address> addresses = new ArrayList<Address>();
	
	public Collection<Address> getAddresses() {
		return addresses;
	}
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
