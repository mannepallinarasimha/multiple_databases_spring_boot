package com.nara.multiple.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nara.multiple.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
