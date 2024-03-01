package com.example.HulkStore.repository;

import com.example.HulkStore.models.shoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<shoppingCart,Long > {
}
