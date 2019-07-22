package com.company.gamestorecontroller.service;

import com.company.gamestorecontroller.dao.ConsoleRepository;
import com.company.gamestorecontroller.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleServiceLayer {
    @Autowired
    private ConsoleRepository consoleRepo;

    public List<Console> getConsoles() {
        return consoleRepo.findAll();
    }

    public Console getOneConsole(Integer id) {
        return consoleRepo.getOne(id);
    }

    public Console addConsole(Console console) {
        consoleRepo.save(console);
        return console;
    }

    public Console updateConsole(Console console) {
        consoleRepo.save(console);
        return console;
    }

    public void deleteConsole(Integer id) {
        consoleRepo.deleteById(id);
    }

    public List<Console> getByManufacturer(String manufacturer) {
        return consoleRepo.findByManufacturer(manufacturer);
    }

}
