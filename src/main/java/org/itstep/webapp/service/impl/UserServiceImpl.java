package org.itstep.webapp.service.impl;

import java.util.List;

import org.itstep.webapp.entity.DbUser;
import org.itstep.webapp.entity.Role;
import org.itstep.webapp.repository.UserRepo;
import org.itstep.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@EnableWebSecurity
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public UserServiceImpl(final UserRepo userRepo) {
    this.userRepo = userRepo;
  }


  @Override public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

    DbUser dbUser = userRepo.findByEmail(email);

    if (dbUser != null){
      User user = new User(dbUser.getEmail(), dbUser.getPassword(), dbUser.getRoles());
      return user;
    }
    return null;
  }

  @Override public DbUser findByEmail(final String email) {
    return userRepo.findByEmail(email);
  }

  @Override public DbUser registerUser(final DbUser user) {

    DbUser checkUser = userRepo.findByEmail(user.getEmail());

    if (checkUser == null){
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      return userRepo.save(user);
    }
    return null;
  }

  @Override public List<DbUser> getAllUsers() {
    return userRepo.findAll();
  }

  @Override public int getUsersCount(final Role roles) {
    return userRepo.countAllByRolesContains(roles);
  }

  @Override public List<DbUser> getAllUsersPaged(final int currentPage, final int size, final Role roles) {
    Pageable pageable = PageRequest.of(currentPage, size);
    return userRepo.findAllByRolesContains(roles, pageable);
  }

  @Override public void updateUser(final DbUser currentUser) {
    userRepo.save(currentUser);
  }
}
