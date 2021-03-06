package com.netcracker.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcracker.cursomc.domain.City;

@Repository
public interface CityDAO extends JpaRepository<City, Integer> {

}
