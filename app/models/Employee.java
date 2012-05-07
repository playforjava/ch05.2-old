package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

@Entity
public class Employee extends Model {

  @Id
  public Long id;

  public String firstName;
  public String lastName;

  @ManyToMany(mappedBy = "employees")
  public List<Warehouse> warehouses;
  
}
