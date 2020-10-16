package org.tushar.app.resources;

import java.util.List;
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
import org.tushar.app.model.Club;
import org.tushar.app.service.AddClub;
import org.tushar.app.service.GetAllClubs;
import org.tushar.app.service.GetClub;
import org.tushar.app.service.RemoveClub;
import org.tushar.app.service.UpdateClub;

import com.mongodb.DBObject;

@Path("/clubs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClubResource {
	
	private Map<Long, Club> clubs = DatabaseClass.getClubs();
	//private ClubService clubService = new ClubService();

	@GET
	public JSONArray getClubs() {
		GetAllClubs getAllClubs = new GetAllClubs();
		return getAllClubs.main(null);
	}

	@POST
	public JSONObject addClub(Club club) {
		//club.setId(clubs.size() + 1);
		clubs.put(club.getId(), club);
		AddClub addClub = new AddClub(club);
		return addClub.main(null);
	}

	@GET
	@Path("/{clubId}")
	public JSONObject getClub(@PathParam("clubId") long id) {
		GetClub getClub = new GetClub(id);
		return getClub.main(null);
	}

	@PUT
	@Path("/{clubId}")
	public JSONObject updateClub(@PathParam("clubId") long clubId, Club club) {
		club.setId(clubId);
		if (club.getId() == 0) {
			return null;
		}
		clubs.put(club.getId(), club);
		UpdateClub updateClub = new UpdateClub(club);
		return updateClub.main(null);
	}

	@DELETE
	@Path("/{clubId}")
	public void deleteClub(@PathParam("clubId") long clubId) {
		RemoveClub removeClub = new  RemoveClub(clubId);
		removeClub.main(null);
	}

}
