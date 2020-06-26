package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Album extends Item{
  @Id
  @GeneratedValue
  private long id;

  private String musician;

  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  public String getMusician() {
    return musician;
  }

  public void setMusician(String musician) {
    this.musician = musician;
  }
}
