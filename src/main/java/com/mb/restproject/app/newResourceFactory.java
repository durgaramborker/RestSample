package com.mb.restproject.app;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("resources")
public class newResourceFactory {

	Repo repo = new Repo();

	@GET
	@Path("getobject/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public NewResource getResourceRepo(@PathParam("id") String id) {
		System.out.println("getcalled");

		return repo.getResourceRepo(id);
		// return "ok";

	}

	@GET
	@Path("getlist")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<NewResource> getResourceRepoList() {

		return repo.getResourceRepo();

	}

	@POST
	@Path("add")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void createResource(NewResource n) {
		System.out.println("adding " + n.getName());
		repo.add(n);

	}
	
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void updateResource(NewResource n) {
		
		if(repo.getResourceRepo(n.getName()).getName().isEmpty())
		{
			repo.add(n);
		}
		else repo.update(n);
	}
	@DELETE
	@Path("kill/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void updateResource(@PathParam("id")String id) {
		
		if(!repo.getResourceRepo((id)).getName().isEmpty())
		{
			repo.delete(id);
		}
		
	}
	

}
