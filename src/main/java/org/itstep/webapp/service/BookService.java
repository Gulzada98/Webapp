package org.itstep.webapp.service;

import java.util.List;

import org.itstep.webapp.entity.Book;

public interface BookService {

  Long countBooks(String name, String author, Integer pageFrom, Integer pageTo, Integer priceFrom, Integer priceTo);

  List<Book> searchBook(Integer page, Integer size, String name, String author, Integer pageFrom, Integer pageTo, Integer priceFrom, Integer priceTo);
}
