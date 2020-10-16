package org.tushar.app.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tushar.app.service.GetImage;

@Path("/club_enigma_image")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({"image/jpeg,image/png"})
public class GetClubEnigmaImage {	
	public String str = "club_enigma_image";	
	@GET
	public byte[] getImages() {
		GetImage getImage = new GetImage(str);
		return getImage.main(null);
	}
}
