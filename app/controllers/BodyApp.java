package controllers;

import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http.RequestBody;
import play.mvc.Result;
import play.mvc.Security.Authenticated;

public class BodyApp extends Controller {

	public static Result index() {
		RequestBody body = request().body();	
		return ok("got body : " + body.asText());
	}
	
	@BodyParser.Of(BodyParser.Json.class)	
	public static Result indexToJson() {
		return ok("got body : " + request().body().asJson());
	}
	
	
	@Authenticated
	public static Result test() {
		
		return null;
	}
}
