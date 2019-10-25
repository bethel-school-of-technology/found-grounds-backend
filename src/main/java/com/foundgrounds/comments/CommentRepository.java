package com.foundgrounds.comments;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foundgrounds.comments.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}