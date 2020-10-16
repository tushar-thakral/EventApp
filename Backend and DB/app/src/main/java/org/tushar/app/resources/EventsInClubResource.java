package org.tushar.app.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.tushar.app.service.GetEventsInClub;

@Path("/eventsInClub")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventsInClubResource {

	@GET
	@Path("/{clubId}")
	public JSONArray getEventsInClub(@PathParam("clubId") long clubId) {
		GetEventsInClub getEventsInClub = new GetEventsInClub(clubId);
		return getEventsInClub.main(null);
	}
	
}
