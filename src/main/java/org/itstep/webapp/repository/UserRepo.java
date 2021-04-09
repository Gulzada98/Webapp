package org.itstep.webapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.itstep.webapp.entity.DbUser;
import org.itstep.webapp.entity.Role;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<DbUser, Long> {

  DbUser findByEmail(String email);

  List<DbUser> findAllByRolesContains(Role role, Pageable pageable);

  int countAllByRolesContains(Role roles);

}
