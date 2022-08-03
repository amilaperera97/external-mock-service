package com.external.mock.repository;

import com.external.mock.entity.Item;
import com.external.mock.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findItemByIdAndShop(Long id, Shop shop);
}
