package org.tushar.app.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tushar.app.model.FollowEvent;
import org.tushar.app.service.FollowingEvent;

@Path("/followEvent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowEventResource {

	@POST
	public boolean FollowEvent(FollowEvent followEvent) {
		FollowingEvent followingEvent = new FollowingEvent(followEvent);
		return followingEvent.main(null);
	}
	
}
