package com.foundgrounds.photos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foundgrounds.photos.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

}
