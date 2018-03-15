package org.koushik.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Profile;
import org.koushik.javabrains.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}

	@GET
	@Path("/{profName}")
	public Profile getProfile(@PathParam("profName") String profName) {
		return profileService.getProfile(profName);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}

	@PUT
	@Path("/{profName}")
	public Profile updateProfile(@PathParam("profName") String profName, Profile profile) {
		profile.setProfileName(profName);
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{profName}")
	public void deleteProfile(@PathParam("profName") String profName) {
		profileService.deleteProfile(profName);
	}
}
