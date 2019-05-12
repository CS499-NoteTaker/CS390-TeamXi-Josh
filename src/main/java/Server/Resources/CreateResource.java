package Server.Resources;

import javax.ws.rs.*;
import java.io.InputStream;

@Path("create")
public class CreateResource {

    @GET
    public InputStream getCreate() { return this.getClass().getResourceAsStream("/create.html");}

    @GET
    @Path("{file}")
    @Produces("application/javascript")
    public InputStream getCreateJavascript(@PathParam("file") String fileName) {
        InputStream stream = this.getClass().getResourceAsStream("/" + fileName);
        if (stream == null){
            throw new WebApplicationException(404);
        }
        return stream;

    }


}