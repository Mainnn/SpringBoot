package com.exampleBostTrap.demo.repos;

import com.exampleBostTrap.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepos extends CrudRepository<User,Long> {
    User findAllById(long i);
}
