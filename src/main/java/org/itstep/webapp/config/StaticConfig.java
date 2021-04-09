package org.itstep.webapp.config;

import org.itstep.webapp.entity.Role;

public class StaticConfig {

  public static final Role ROLE_USER = new Role(1L, "ROLE_USER", "User role");
  public static final Role ROLE_ADMIN = new Role(2L, "ROLE_ADMIN", "Admin role");
  public static final Role ROLE_MODERATOR = new Role(3L, "ROLE_MODERATOR", "MOderator role");

  public static final int PAGE_SIZE = 5;

  private StaticConfig() {
  }
}
