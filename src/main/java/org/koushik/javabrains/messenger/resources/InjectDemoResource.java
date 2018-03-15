package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	public String getInjectedParams(@MatrixParam("param") String param, @HeaderParam("customHeader") String header,
			@CookieParam("JSESSIONID") String cookie) {
		return "Matrix param: " + param + " Header: " + header + " and cookie: " + cookie;
	}

	@GET
	@Path("context")
	public String getParametersUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String p = uriInfo.getAbsolutePath().toString();
		String co = headers.getCookies().values().toString();
		return "Path: " + p + " ;| Cookies: " + co;
	}

}
