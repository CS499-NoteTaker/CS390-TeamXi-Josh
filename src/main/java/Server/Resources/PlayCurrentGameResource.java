package Server.Resources;

import javax.ws.rs.*;
import java.io.InputStream;

@Path("PlayCurrentGame")
public class PlayCurrentGameResource {

    @GET
    public InputStream getPlay() { return this.getClass().getResourceAsStream("/PlayCurrentGame.html");}

    @GET
    @Path("{file}")
    @Produces("application/javascript")
    public InputStream getPlayJavascript(@PathParam("file") String fileName) {
        InputStream stream = this.getClass().getResourceAsStream("/" + fileName);
        if (stream == null){
            throw new WebApplicationException(404);
        }
        return stream;

    }


}
