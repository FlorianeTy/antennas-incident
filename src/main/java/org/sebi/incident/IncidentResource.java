package org.sebi.incident;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("rest/incidents")
public class IncidentResource {

    @ConfigProperty(name = "apikey")
    String apiKey;

    @ConfigProperty(name = "version")
    String version;
     

    @GET
    public Response getIncidents(@QueryParam("api_key") String apiKey){
        if(this.apiKey.equals(apiKey)){
            return Response.ok(Incident.listAll()).build();
        }
       return Response.status(Response.Status.UNAUTHORIZED).build();
    } 

    @GET
    @Path("version")
    public String version(){
        return version;
    }
}
