package org.tushar.app.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tushar.app.model.Authentication;
import org.tushar.app.service.AddAuthKeys;
import org.tushar.app.service.AuthenticateUser;

@Path("/authenticate")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

	@POST
	public boolean AuthenticationUser(Authentication authentication) {
		AuthenticateUser authenticateUser = new AuthenticateUser(authentication);
		return authenticateUser.main(null);
	}
	
	@POST
	@Path("/addAuthKeys")
	public boolean addAuthKeys(Authentication authentication) {
		AddAuthKeys addAuthKeys = new AddAuthKeys(authentication);
		return addAuthKeys.main(null);
	}

}
