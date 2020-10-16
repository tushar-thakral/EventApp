package org.tushar.app.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.tushar.app.database.DatabaseClass;
import org.tushar.app.model.Event;
import org.tushar.app.model.Profile;

public class EventService {
	
	private Map<Long, Event> events = DatabaseClass.getEvents();

	public EventService() {
		events.put(1L, new Event(1L, 1L, "abc", "def", "11/04/2018", "10:01:01"));
	}

	public List<Event> getAllEvents() {
		return new ArrayList<Event>(events.values());
	}

	public Event getEvent(long id) {
		return events.get(id);
	}

	public Event addEvent(Event event) {
		event.setId(events.size() + 1);
		events.put(event.getId(), event);
		return event;
	}

	public Event updateEvent(Event event) {
		if (event.getId()==0) {
			return null;
		}
		events.put(event.getId(), event);
		return event;
	}

	public Event removeEvent(long id) {
		return events.remove(id);
	}

}
