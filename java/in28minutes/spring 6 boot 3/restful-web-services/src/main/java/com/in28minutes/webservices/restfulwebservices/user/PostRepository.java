package com.in28minutes.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {
    // @Query("SELECT p FROM Post p WHERE p.id = :postId AND p.user.id = :userId")
    Post findPostByIdAndUserId(@Param("postId") int postId, @Param("userId") int userId);
}
