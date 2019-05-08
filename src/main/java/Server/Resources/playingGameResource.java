package Server.Resources;

import javax.ws.rs.*;
import java.io.InputStream;
@Path("playingGame")
public class playingGameResource {


    @GET
    public InputStream getReview() { return this.getClass().getResourceAsStream("/playingGame.html");}

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
