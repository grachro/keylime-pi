package controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import models.Line;
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.list;

public class ListController extends Controller {

	public static Result index() {

		Finder<String, Line> finder = new Finder<String, Line>(String.class,
				Line.class);
		List<Line> lines = finder.all();
		StringBuilder msg = new StringBuilder();
		for (Line line : lines) {
			msg.append(line).append("\n");
		}

		return ok(list.render(lines));
	}

	public static Result addList(String datetime, String temperature) {
		Line line = new Line();
		line.datetime = datetime;
		line.temperature = new BigDecimal(temperature);
		line.save();

		return ok("success");
	}
}