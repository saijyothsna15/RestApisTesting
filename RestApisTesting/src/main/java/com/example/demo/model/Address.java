package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String doorNo;
	private String street;
	private String town;
	private String mandal;
	private String district;
	private String state;
	private String country;
	@Override
	public String toString() {
		return "Address [mandal=" + mandal + ", district=" + district + ", state=" + state + ", country=" + country
				+ "]";
	}
}
