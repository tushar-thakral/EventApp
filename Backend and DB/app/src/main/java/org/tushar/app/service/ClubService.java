package org.tushar.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tushar.app.database.DatabaseClass;
import org.tushar.app.model.Club;
import org.tushar.app.model.Profile;

public class ClubService {

	private Map<Long, Club> clubs = DatabaseClass.getClubs();

	public ClubService() {
		clubs.put(1L, new Club(1L, 10, "CS", "123", "xyz"));
	}

	public List<Club> getAllClubs() {
		return new ArrayList<Club>(clubs.values());
	}

	public Club getClub(long id) {
		return clubs.get(id);
	}

	public Club addClub(Club club) {
		club.setId(clubs.size() + 1);
		clubs.put(club.getId(), club);
		return club;
	}

	public Club updateClub(Club club) {
		if (club.getId()==0) {
			return null;
		}
		clubs.put(club.getId(), club);
		return club;
	}

	public Club removeClub(long id) {
		return clubs.remove(id);
	}

}
