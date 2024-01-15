package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByLoginAndPassword(String login, String password);
}
