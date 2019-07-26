package com.tts.TechTalentTwitter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tts.TechTalentTwitter.model.User;

/**
 * @author Michele Lanning
 * @version 2019-07-22
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
