package com.foundgrounds.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foundgrounds.reviews.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}