package controllers;

import static java.lang.String.format;
import models.Product;
import models.StockItem;
import models.Warehouse;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

  public static Result index() {
    Warehouse warehouse = new Warehouse();
    warehouse.name = "My Warehouse";

    Product product = new Product();
    product.name = "Stainless steel paperclips, small, 1000pcs";
    product.ean = 1234L;
    product.description = "1000 blue paperclips.";

    StockItem item = new StockItem();
    item.quantity = 15L;
    item.product = product;

    item.warehouse = warehouse;
    warehouse.stock.add(item);

    Logger.info(format("My warehouse is called '%s'", warehouse));
    Logger.info(format("It contains %d items", warehouse.stock.size()));
    Logger.info(format("The first is: %s", warehouse.stock.get(0)));
    
    product.save();
    item.save();
    warehouse.save();

    return ok(index.render("Your new application is ready."));
  }

}