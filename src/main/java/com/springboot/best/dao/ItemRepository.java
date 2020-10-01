package com.springboot.best.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.best.model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
