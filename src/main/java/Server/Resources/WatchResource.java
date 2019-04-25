package Server.Resources;

import javax.ws.rs.*;
import java.io.InputStream;

@Path("watch")
public class WatchResource {

    @GET
    public InputStream getReview() { return this.getClass().getResourceAsStream("/watch.html");}

    @GET
    @Path("{file}")
    @Produces("application/javascript")
    public InputStream getWatchJavascript(@PathParam("file") String fileName) {
        InputStream stream = this.getClass().getResourceAsStream("/" + fileName);
        if (stream == null){
            throw new WebApplicationException(404);
        }
        return stream;

    }
}
