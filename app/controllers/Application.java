package controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import models.Line;
import play.db.DB;
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        Object connection = DB.getConnection();
        
        {
        Line line = new Line();
        line.datetime = new Date().toString();
        line.temperature = new BigDecimal(new Date().getTime());
        line.save();
        }
        
        Finder<String, Line> finder = new Finder<String, Line>(String.class, Line.class);
        List<Line> lines =  finder.all();
        System.out.println("lines::START");
        for (Line line:lines) {
            System.out.println(line);
        }
        System.out.println("lines::END");
        
        return ok(index.render("Your new application is ready."));
    }

}
