package Server.Resources;

import javax.ws.rs.*;
import java.io.InputStream;

@Path("client")
public class ClientResource {

    @GET
    public InputStream getClient() {return this.getClass().getResourceAsStream("/client.html");}

    @GET
    @Path("{file}")
    @Produces("application/javascript")
    public InputStream getClientJavascript(@PathParam("file") String fileName){
        InputStream stream = this.getClass().getResourceAsStream("/" + fileName);
        if(stream == null){
            throw new WebApplicationException(404);
        }
        return stream;
    }
}
