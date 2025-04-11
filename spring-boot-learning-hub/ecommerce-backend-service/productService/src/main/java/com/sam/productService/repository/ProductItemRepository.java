package com.sam.productService.repository;

import com.sam.productService.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {


    @Modifying
    @Query(nativeQuery = true, value = "update product_items set quantity =?2 where id=?1")
    void updateQuantity(Long id, Integer quantity);

}

