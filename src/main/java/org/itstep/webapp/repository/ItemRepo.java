package org.itstep.webapp.repository;

import javax.transaction.Transactional;

import org.itstep.webapp.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ItemRepo extends JpaRepository<Item, Long> {

}
