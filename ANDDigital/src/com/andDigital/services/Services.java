package com.andDigital.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.andDigital.entity.Customer;
import com.andDigital.entity.Phones;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/customer")
public class Services implements Serializable, Iservices {
	private static final long serialVersionUID = 1L;
	private List<Customer> listCustomer = new ArrayList<Customer>();
	boolean activated;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getAllPhones() {
		listCustomer = this.createObject();

		return (Response.status(Response.Status.OK).entity(listCustomer).build());
	}

	@GET
	@Path("/getPhone/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getPhoneById(@PathParam("id") int id) {
		listCustomer = this.createObject();

		Customer data = listCustomer.stream().filter(customer -> id == customer.getId()).findAny().orElse(null);

		if (data == null) {
			Map<String, String> mapError = new HashMap<String, String>();
			mapError.put("Error: ", "Customer not found!");

			return (Response.status(Response.Status.BAD_REQUEST).entity(mapError).build());
		}

		return (Response.status(Response.Status.OK).entity(data).build());
	}

	@PUT
	@Path("/activate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response activatedNumber(String json) {
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
		
		String number = jsonObject.get("number").getAsString();

		activated = false;
		listCustomer = this.createObject();
		
		listCustomer.forEach((Customer c) -> {
			List<Phones> data = c.getListPhones();
			data.forEach((Phones p) -> {
				if (number.equals(p.getPhone()))
				{
					activated = true;
					p.setActivated(true);
				}
			});
		});

		if (!activated)
		{
			Map<String, String> mapError = new HashMap<String, String>();
			mapError.put("Error: ", "Phone not found!");

			return (Response.status(Response.Status.BAD_REQUEST).entity(mapError).build());
		}

		Map<String, String> mapSuccess = new HashMap<String, String>();
		mapSuccess.put("Success: ", "Phone activated.");

		return (Response.status(Response.Status.OK).entity(mapSuccess).build());
	}

	@Override
	public List<Customer> createObject() {
		/* Customer 1 */
		Customer customer = new Customer();

		List<Phones> listPhones = new ArrayList<Phones>() {
			{
				add(new Phones("197654321", true));
				add(new Phones("293456789", false));
				add(new Phones("394987312", true));
				add(new Phones("493789456", false));
			}
		};
		customer.setId(1);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);

		/* Customer 2 */
		customer = new Customer();

		listPhones = new ArrayList<Phones>() {
			{
				add(new Phones("597258369", true));
				add(new Phones("691852963", false));
				add(new Phones("798741369", true));
			}
		};
		customer.setId(2);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);

		/* Customer 3 */
		customer = new Customer();

		listPhones = new ArrayList<Phones>() {
			{
				add(new Phones("897654321", true));
			}
		};
		customer.setId(3);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);

		/* Customer 4 */
		customer = new Customer();

		listPhones = new ArrayList<Phones>() {
			{
				add(new Phones("997654321", true));
				add(new Phones("113456780", false));
				add(new Phones("224987312", true));
				add(new Phones("333789456", false));
			}
		};
		customer.setId(4);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);

		/* Customer 5 */
		customer = new Customer();

		listPhones = new ArrayList<Phones>() {
			{
				add(new Phones("441623684", true));
				add(new Phones("558152639", false));
				add(new Phones("664512235", true));
				add(new Phones("776431582", false));
			}
		};
		customer.setId(5);
		customer.setListPhones(listPhones);

		listCustomer.add(customer);

		return (listCustomer);
	}
}
