package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Product extends Model {

  @Id
  public Long id;

  public Long ean;
  public String name;
  public String description;

  @OneToMany
  public List<StockItem> stockItems;

  public static Finder<Long, Product> find() {
    return new Finder<Long, Product>(Long.class, Product.class);
  }

}
