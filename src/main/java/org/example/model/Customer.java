package org.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="customers")
public class Customer {

  //First the content from the database is fetched then it is mapped to Customer class object
  //and at that time only value of id is type-casted to string
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="customer_id")
  private Long id;
  private String name;
  private String city;
  private String zipcode;
  private Integer status;
  @Column(name="date_of_birth")
  private Date dateTime;

  public String getZipcode() {
    return zipcode;
  }

  public Integer getStatus() {
    return status;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", city='" + city + '\'' +
            ", zipcode='" + zipcode + '\'' +
            ", status=" + status +
            ", dateTime='" + dateTime + '\'' +
            '}';
  }

}
