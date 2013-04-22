package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
  
    public static Result test() {
    	return ok("It works");
    }
    
    public static Result test2(long id) {
    	return ok("test2 parameter : " + id);
    }
    
    public static Result test4(String id) {
    	return ok("tet4 : " + id);
    }
    
    public static Result test5(int page) {
    	return ok("<h1>test5 : " + page + "</h1>").as("text/html");
    }
    
    public static Result user() {
    	String user = session("connected");
    	if(user != null) {
    		return ok("hello" + user);
    	} else {
    		session("connected", "park");
    		return unauthorized("oops");
    	}
    }
}
