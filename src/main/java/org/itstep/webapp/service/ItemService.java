package org.itstep.webapp.service;

import java.util.List;

import org.itstep.webapp.entity.Item;

public interface ItemService {

  Item getItem(Long id);

  List<Item> getAllItem();

  void saveItem(Item item);

  void deleteItemByid(Long id);
}
