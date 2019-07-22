package com.company.gamestorecontroller.service;

import com.company.gamestorecontroller.dao.TshirtRepository;
import com.company.gamestorecontroller.dto.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TshirtServiceLayer {
    @Autowired
    private TshirtRepository tshirtRepo;

    public Tshirt addShirt(Tshirt shirt) {
        tshirtRepo.save(shirt);
        return shirt;
    }

    public List<Tshirt> getShirt() {
        return tshirtRepo.findAll();
    }

    public Tshirt getOneShirt(Integer id) {
        return tshirtRepo.getOne(id);
    }

    public Tshirt updateShirt(Tshirt shirt) {
        tshirtRepo.save(shirt);
        return shirt;
    }

    public void deleteShirt(Integer id) {
        tshirtRepo.deleteById(id);
    }

    public List<Tshirt> getByColor(String color) {
        return tshirtRepo.findByColor(color);
    }

    public List<Tshirt> getBySize(String size) {
        return tshirtRepo.findBySize(size);
    }
}
