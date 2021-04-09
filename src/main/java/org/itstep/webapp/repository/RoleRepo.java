package org.itstep.webapp.repository;

import javax.transaction.Transactional;

import org.itstep.webapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface RoleRepo extends JpaRepository<Role, Long> {
}
