package hellojpa;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Item extends Product{
  @Id
  @GeneratedValue
  private long id;

  private String name;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
