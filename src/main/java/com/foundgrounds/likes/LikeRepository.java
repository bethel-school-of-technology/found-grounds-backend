package com.foundgrounds.likes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foundgrounds.likes.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

	
}
