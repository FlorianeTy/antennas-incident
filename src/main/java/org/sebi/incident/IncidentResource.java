package org.sebi.incident;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("rest/incidents")
public class IncidentResource {

    @ConfigProperty(name = "apikey")
    String apiKey;

    @ConfigProperty(name = "version")
    String version;
     

    @GET
    public List<Incident> getIncidents(@QueryParam("api_key") String apiKey){
        if(this.apiKey.equals(apiKey)){
            return Incident.listAll();
        }
       return null;
    } 

    @GET
    @Path("version")
    public String version(){
        return version;
    }
}
