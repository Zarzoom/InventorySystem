package com.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
}
