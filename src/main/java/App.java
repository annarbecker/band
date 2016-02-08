import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/homepage.vtl" );
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

  get("/albums", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/albums.vtl" );
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/tickets", (request, response) -> {
        HashMap model = new HashMap();
        model.put("template", "templates/tickets.vtl" );
        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());

      get("/receipt", (request, response) -> {
        HashMap model = new HashMap();
        String name = request.queryParams("name");
        String concert = request.queryParams("concert");
        String quantity = request.queryParams("quantity");

        model.put("name", name);
        model.put("concert", concert);
        model.put("quantity", quantity);
        model.put("template", "templates/receipt.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  }
}
