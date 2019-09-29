package com.tts.TechTalentTwitter.repository;

import com.tts.TechTalentTwitter.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Michele Lanning
 * @version 2019-07-29
 */
@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findByPhrase(String phrase);

    //*Functionality  is the ability to get a tag based on its phrase.
}
