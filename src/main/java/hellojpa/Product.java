package hellojpa;

import static javax.persistence.InheritanceType.JOINED;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Product {

  @Id @GeneratedValue
  private long id;
  private int prodNum;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getProdNum() {
    return prodNum;
  }

  public void setProdNum(int prodNum) {
    this.prodNum = prodNum;
  }
}
