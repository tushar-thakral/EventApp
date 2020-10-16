package org.tushar.app.model;

public class FollowEvent {
	
	private long profileId;
	private long eventId;
	
	public FollowEvent() {
		
	}
	
	public FollowEvent(long profileId, long eventId) {
		this.profileId = profileId;
		this.eventId = eventId;
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	
}
