package com.andDigital.services;

import java.util.List;

import javax.ws.rs.core.Response;

import com.andDigital.entity.Customer;

public interface Iservices
{
	public Response getAllPhones();

	public List<Customer> createObject();
}
