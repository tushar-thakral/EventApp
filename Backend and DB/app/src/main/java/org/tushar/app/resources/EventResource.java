package org.tushar.app.resources;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.tushar.app.database.DatabaseClass;
import org.tushar.app.model.Event;
import org.tushar.app.service.AddEvent;
import org.tushar.app.service.GetAllEvents;
import org.tushar.app.service.GetEvent;
import org.tushar.app.service.RemoveEvent;
import org.tushar.app.service.UpdateEvent;

@Path("/events")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

	private Map<Long, Event> events = DatabaseClass.getEvents();
	//private ClubService clubService = new ClubService();

	@GET
	public JSONArray getEvents() {
		GetAllEvents getAllEvents = new GetAllEvents();
		return getAllEvents.main(null);
	}

	@POST
	public JSONObject addEvent(Event event) {
		//event.setId(events.size() + 1);
		events.put(event.getId(), event);
		AddEvent addEvent = new AddEvent(event);
		return addEvent.main(null);
	}

	@GET
	@Path("/{eventId}")
	public JSONObject getEvent(@PathParam("eventId") long id) {
		GetEvent getEvent = new GetEvent(id);
		return getEvent.main(null);
	}

	@PUT
	@Path("/{eventId}")
	public JSONObject updateEvent(@PathParam("eventId") long eventId, Event event) {
		event.setId(eventId);
		if (event.getId() == 0) {
			return null;
		}
		events.put(event.getId(), event);
		UpdateEvent updateEvent = new UpdateEvent(event);
		return updateEvent.main(null);
	}

	@DELETE
	@Path("/{eventId}")
	public void deleteEvent(@PathParam("eventId") long eventId) {
		RemoveEvent removeEvent = new  RemoveEvent(eventId);
		removeEvent.main(null);
	}

}
