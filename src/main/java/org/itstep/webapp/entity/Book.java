package org.itstep.webapp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Book extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "author")
  private String author;

  @Column(name = "page")
  private Integer page;

  @Column(name = "price")
  private Integer price;
}
