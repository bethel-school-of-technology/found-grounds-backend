package com.foundgrounds.menu;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foundgrounds.menu.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	
}
