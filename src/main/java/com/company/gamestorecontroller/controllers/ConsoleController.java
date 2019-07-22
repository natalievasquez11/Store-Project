package com.company.gamestorecontroller.controllers;

import com.company.gamestorecontroller.dto.Console;
import com.company.gamestorecontroller.service.ConsoleServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {
    @Autowired
    private ConsoleServiceLayer consoleService;

    @RequestMapping(value="/consoles", method= RequestMethod.GET)
    public List<Console> findConsoles() {
        return consoleService.getConsoles();
    }

    @RequestMapping(value="/consoles/{id}", method= RequestMethod.GET)
    public Console findOneConsole(@PathVariable Integer id) {
        return consoleService.getOneConsole(id);
    }

    @RequestMapping(value="/consoles", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {
        consoleService.addConsole(console);
        return console;
    }

    @RequestMapping(value="/consoles/{id}", method= RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public Console putConsole(@RequestBody @Valid Console console) {
        consoleService.updateConsole(console);
        return console;
    }

    @RequestMapping(value="/deleteConsole/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void delConsole(@PathVariable Integer id) {
        consoleService.deleteConsole(id);
    }

    @RequestMapping(value="/manufacturer/{manufacturer}", method= RequestMethod.GET)
    public List<Console> getManufacturer(@PathVariable String manufacturer) {
        return consoleService.getByManufacturer(manufacturer);
    }

}
