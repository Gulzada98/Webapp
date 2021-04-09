package org.itstep.webapp.service;

import java.util.List;

import org.itstep.webapp.entity.DbUser;
import org.itstep.webapp.entity.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  DbUser findByEmail(String email);

  DbUser registerUser(DbUser user);

  List<DbUser> getAllUsers();

  int getUsersCount(Role roles);

  List<DbUser> getAllUsersPaged(int currentPage, int size, Role roles);

  void updateUser(DbUser currentUser);
}
