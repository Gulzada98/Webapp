package org.itstep.webapp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.itstep.webapp.entity.Book;
import org.itstep.webapp.repository.BookRepo;
import org.itstep.webapp.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookServiceImpl implements BookService {

  private final BookRepo bookRepository;

  public BookServiceImpl(final BookRepo bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override public Long countBooks(final String name, final String author, final Integer pageFrom, final Integer pageTo, final Integer priceFrom, final Integer priceTo) {

    Specification specification = (Specification<Book>)(root, query, builder) -> builder.like(builder.upper(root.get("name")), "%"+name.toUpperCase()+"%");

    if (!author.equals("")){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.like(builder.upper(root.get("author")), "%"+author.toUpperCase()+"%"));
    }

    if(pageFrom != 0){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.greaterThanOrEqualTo(root.get("page"), pageFrom));
    }

    if (pageTo != 0){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.lessThanOrEqualTo(root.get("page"), pageTo));
    }

    if(priceFrom != 0){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), priceFrom));
    }

    if (priceTo != 0){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), priceTo));
    }

    return bookRepository.count(specification);
  }

  @Override public List<Book> searchBook(final Integer page, final Integer size, final String name, final String author, final Integer pageFrom, final Integer pageTo, final Integer priceFrom,
      final Integer priceTo) {

    Pageable pageable = PageRequest.of(page, size);

    Specification specification = (Specification<Book>)(root, query, builder) -> builder.like(builder.upper(root.get("name")), "%"+name.toUpperCase()+"%");

    if (!author.equals("")){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.like(builder.upper(root.get("author")), "%"+author.toUpperCase()+"%"));
    }

    if(pageFrom != 0){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.greaterThanOrEqualTo(root.get("page"), pageFrom));
    }

    if (pageTo != 0){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.lessThanOrEqualTo(root.get("page"), pageTo));
    }

    if(priceFrom != 0){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), priceFrom));
    }

    if (priceTo != 0){
      specification = specification.and((Specification<Book>)(root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), priceTo));
    }

    Page bookPages = bookRepository.findAll(specification, pageable);

    return bookPages.getContent();
  }
}
