package org.itstep.webapp.repository;

import org.itstep.webapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo  extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
