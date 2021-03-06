package org.tushar.app.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.tushar.app.service.GetFollowingEvents;

@Path("/getFollowingEvents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GetFollowingEventsResource {

	@GET
	@Path("/{profileId}")
	public JSONArray getFollowingEvents(@PathParam("profileId") long profileId) {
		GetFollowingEvents getFollowingEvents = new GetFollowingEvents(profileId);
		return getFollowingEvents.main(null);
	}
}
