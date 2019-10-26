package com.foundgrounds.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foundgrounds.posts.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}