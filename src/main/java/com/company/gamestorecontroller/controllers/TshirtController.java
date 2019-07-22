package com.company.gamestorecontroller.controllers;

import com.company.gamestorecontroller.dto.Tshirt;
import com.company.gamestorecontroller.service.TshirtServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TshirtController {
    @Autowired
    private TshirtServiceLayer shirtService;

    @RequestMapping(value="/shirts", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Tshirt createShirt(@RequestBody @Valid Tshirt shirt) {
        shirtService.addShirt(shirt);
        return shirt;
    }

    @RequestMapping(value="/shirts", method= RequestMethod.GET)
    public List<Tshirt> findShirt() {
        return shirtService.getShirt();
    }

    @RequestMapping(value="/shirts/{id}", method= RequestMethod.GET)
    public Tshirt findOneShirt(@PathVariable Integer id) {
        return shirtService.getOneShirt(id);
    }

    @RequestMapping(value="/shirts/{id}", method= RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public Tshirt putShirt(@RequestBody @Valid Tshirt shirt) {
        shirtService.updateShirt(shirt);
        return shirt;
    }

    @RequestMapping(value="/deleteshirt/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void delShirt(@PathVariable Integer id) {
        shirtService.deleteShirt(id);
    }

    @RequestMapping(value="/color/{color}", method= RequestMethod.GET)
    public List<Tshirt> getColor(@PathVariable String color) {
        return shirtService.getByColor(color);
    }

    @RequestMapping(value="/size/{size}", method= RequestMethod.GET)
    public List<Tshirt> getSize(@PathVariable String size) {
        return shirtService.getBySize(size);
    }
}
