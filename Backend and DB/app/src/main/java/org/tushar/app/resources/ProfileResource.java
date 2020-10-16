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
import org.tushar.app.model.Profile;
import org.tushar.app.service.AddProfile;
import org.tushar.app.service.GetAllProfiles;
import org.tushar.app.service.GetProfile;
import org.tushar.app.service.RemoveProfile;
import org.tushar.app.service.UpdateProfile;

import com.mongodb.DBObject;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private long count = 0;

	private Map<Long, Profile> profiles = DatabaseClass.getProfiles();
	// private ProfileService profileService = new ProfileService();

	@GET
	public JSONArray getProfiles() {
		GetAllProfiles getAllProfiles = new GetAllProfiles();
		return getAllProfiles.main(null);
	}

	@POST
	public boolean addProfile(Profile profile) {
		profile.setId(count + 1);
		count += 1;
		profiles.put(profile.getId(), profile);
		AddProfile addProfile = new AddProfile(profile);
		return addProfile.main(null);
	}

	@GET
	@Path("/{profileId}")
	public JSONObject getProfile(@PathParam("profileId") long id) {
		GetProfile getProfile = new GetProfile(id);
		return getProfile.main(null);
	}

	@PUT
	@Path("/{profileId}")
	public boolean updateProfile(@PathParam("profileId") long profileId, Profile profile) {
		profile.setId(profileId);
		if (profile.getId() == 0) {
			return false;
		}
		profiles.put(profile.getId(), profile);
		UpdateProfile updateProfile = new UpdateProfile(profile);
		return updateProfile.main(null);
	}

	@DELETE
	@Path("/{profileId}")
	public void deleteProfile(@PathParam("profileId") long profileId) {
		RemoveProfile removeProfile = new  RemoveProfile(profileId);
		count -= 1;
		removeProfile.main(null);
	}

}
