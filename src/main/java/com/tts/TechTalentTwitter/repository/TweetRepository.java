package com.tts.TechTalentTwitter.repository;

import com.tts.TechTalentTwitter.model.Tweet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.tts.TechTalentTwitter.model.User;
import com.tts.TechTalentTwitter.repository.TweetRepository;


/**
 * @author Michele Lanning
 * @version 2019-07-22
 */
@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findAllByOrderByCreatedAtDesc();

    List<Tweet> findAllByUserOrderByCreatedAtDesc(User user);

    List<Tweet> findAllByUserInOrderByCreatedAtDesc(List<User> users);
}
