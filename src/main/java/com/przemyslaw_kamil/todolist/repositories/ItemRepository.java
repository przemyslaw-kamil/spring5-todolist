package com.przemyslaw_kamil.todolist.repositories;

import com.przemyslaw_kamil.todolist.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
