package com.tobeto.pair7Demo.repositories;

import com.tobeto.pair7Demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>
{ }
