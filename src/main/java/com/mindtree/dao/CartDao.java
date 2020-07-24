package com.mindtree.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

}
