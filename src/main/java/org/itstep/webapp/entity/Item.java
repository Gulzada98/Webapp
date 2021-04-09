package org.itstep.webapp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "t_item")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name",
          length = 200)
  private String name;

  private Integer price;

  @Column(name = "description",
          columnDefinition = "TEXT")
  private String description;

  private Integer amount;

  @ManyToOne(fetch = FetchType.EAGER)
  private Country country;

}
