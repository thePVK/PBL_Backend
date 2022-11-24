package com.example.pbl_api.repository;

import com.example.pbl_api.entity.Cart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {
    List<Cart> findCartsByUserId(long id);

    @Transactional
    @Modifying
    void deleteCartByProductIdAndUserId(long productId,long CartId);

    Cart findCartByProductIdAndUserId(long productId,long CartId);


    Cart findCartById(long id);

}
