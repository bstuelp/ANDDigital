package com.andDigital.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.andDigital.entity.Customer;
import com.andDigital.entity.Phones;

@Path("/customer")
public class Services implements Serializable, Iservices
{
	private static final long serialVersionUID = 1L;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getAllPhones()
	{
		List<Customer> listCustomer = new ArrayList<Customer>();

		listCustomer = this.createObject();

		return(Response.status(Response.Status.OK).entity(listCustomer).build());
	}

	@Override
	public List<Customer> createObject()
	{
		List<Customer> listCustomer = new ArrayList<Customer>();

		/*Customer 1*/
		Customer customer = new Customer();

		List<Phones> listPhones = new ArrayList<Phones>(){{
			add(new Phones("987654321", true));
			add(new Phones("123456789", false));
			add(new Phones("654987312", true));
			add(new Phones("123789456", false));
		}};
		customer.setId(1);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);


		/*Customer 2*/
		customer = new Customer();

		listPhones = new ArrayList<Phones>(){{
			add(new Phones("147258369", true));
			add(new Phones("741852963", false));
			add(new Phones("258741369", true));
		}};
		customer.setId(2);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);


		/*Customer 3*/
		customer = new Customer();

		listPhones = new ArrayList<Phones>(){{
			add(new Phones("987654321", true));
		}};
		customer.setId(3);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);


		/*Customer 4*/
		customer = new Customer();

		listPhones = new ArrayList<Phones>(){{
			add(new Phones("987654321", true));
			add(new Phones("123456789", false));
			add(new Phones("654987312", true));
			add(new Phones("123789456", false));
		}};
		customer.setId(4);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);


		/*Customer 5*/
		customer = new Customer();

		listPhones = new ArrayList<Phones>(){{
			add(new Phones("951623684", true));
			add(new Phones("748152639", false));
			add(new Phones("784512235", true));
			add(new Phones("976431582", false));
		}};
		customer.setId(5);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);
		
		return (listCustomer);		
	}
}
