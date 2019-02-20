package com.andDigital.services;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.andDigital.entity.Customer;

public interface Iservices
{
	public Response getAllPhones();

	public List<Customer> createObject();

	public Response getPhoneById(@PathParam("id") int id);

	public Response activatedNumber(String number);
}
