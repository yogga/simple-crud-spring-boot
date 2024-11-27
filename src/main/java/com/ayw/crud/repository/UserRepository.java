package com.ayw.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ayw.crud.entity.User;
public interface UserRepository extends JpaRepository<User, Integer> {

}
