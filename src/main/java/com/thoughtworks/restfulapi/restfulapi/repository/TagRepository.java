package com.thoughtworks.restfulapi.restfulapi.repository;

import com.thoughtworks.restfulapi.restfulapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
