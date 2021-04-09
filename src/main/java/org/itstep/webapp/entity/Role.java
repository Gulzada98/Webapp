package org.itstep.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_roles")
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long Id;

  @Column(name = "role")
  private String role;

  @Column(name = "description")
  private String description;


  @Override public String getAuthority() {
    return role;
  }
}
