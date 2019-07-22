package com.company.gamestorecontroller.dao;


import com.company.gamestorecontroller.dto.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Integer> {

    List<Console> findByManufacturer(String manufacturer);
}

