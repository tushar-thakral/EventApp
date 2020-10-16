package org.tushar.app.service;

import java.util.List;
import java.util.Map;

import org.tushar.app.database.DatabaseClass;
import org.tushar.app.model.Profile;

import com.mongodb.DBObject;

public class ProfileService {

	private Map<Long, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		// profiles.put(1L, new Profile(1L, "Tushar", "Thakral", "IIIT-B",
		// 94664, "tushar.thakral@iiitb.org", "123"));
		// profiles.put(2L, new Profile(2L, "Mehul", "Thakral", "PES-U", 903457,
		// "mehul.thakral@gmail.com", "234"));
	}

	public List<DBObject> getAllProfiles() {
		GetAllProfiles getAllProfiles = new GetAllProfiles();
		return getAllProfiles.main(null);
	}

	/*public DBObject getProfile(long id) {
		GetProfile getProfile = new GetProfile(id);
		return getProfile.main(null);
	}
*/
	
	/*public DBObject addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getId(), profile);
		AddProfile addProfile = new AddProfile(profile);
		return addProfile.main(null);
	}
*/
	
	/*public DBObject updateProfile(Profile profile) {
		if (profile.getId() == 0) {
			return null;
		}
		profiles.put(profile.getId(), profile);
		UpdateProfile updateProfile = new UpdateProfile(profile);
		return updateProfile.main(null);
	}
*/
	public void removeProfile(long id) {
	}

}
