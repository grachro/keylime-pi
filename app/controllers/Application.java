package controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import models.Line;
import play.db.DB;
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

	public static Result index() {
        
        {
        Line line = new Line();
        line.datetime = new Date().toString();
        line.temperature = new BigDecimal(new Date().getTime());
        line.save();
        }
        
        Finder<String, Line> finder = new Finder<String, Line>(String.class, Line.class);
        List<Line> lines =  finder.all();
        StringBuilder msg = new StringBuilder();
        for (Line line:lines) {
        	msg.append(line).append("\n");
        }
        //return ok(msg.toString());
        return ok(list.render(lines));  
    }
}
