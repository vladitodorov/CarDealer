package com.todorov.cardealer.web.controllers;

import com.todorov.cardealer.service.models.CarServiceModel;
import com.todorov.cardealer.service.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("create");
    }

    @PostMapping("/create")
    public ModelAndView createConfirm(@ModelAttribute CarServiceModel model){
        this.carService.save(model);

        return new ModelAndView("redirect:/all");
    }

    @GetMapping("/all")
    public ModelAndView all(ModelAndView modelAndView){
        List<CarServiceModel> cars = this.carService.getCars();
        modelAndView.addObject("cars", cars);
        modelAndView.setViewName("all");
        return modelAndView;
    }
}
