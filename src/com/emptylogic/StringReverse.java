package com.emptylogic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 
import org.json.JSONException;
import org.json.JSONObject;

@Path("/reverse")
public class StringReverse 
{
	@Path("/json/{word}")
	@GET
	@Produces("application/json")
	public Response jsonReversEchoService(@PathParam("word") String word) throws JSONException 
	{
		StringBuilder sb = new StringBuilder();
		sb.append(word);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("original", sb.toString());
		jsonObject.put("reversed", sb.reverse().toString());
		
		String result = "" + jsonObject;
		return Response.status(200).entity(result).build();
	}

	@Path("/xml/{word}")
	@GET
	@Produces("application/xml")
	public String xmlReverseEchoService(@PathParam("word") String word)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(word);
		
		return "<word>" + "<original>" + sb.toString() + "</original>" + "<reversed>" 
		       + sb.reverse().toString() + "</reversed>" + "</word>";
	}
}