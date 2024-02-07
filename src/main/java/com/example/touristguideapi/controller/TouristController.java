package com.example.touristguideapi.controller;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private TouristService touristService;

    public TouristController(){
        this.touristService = new TouristService();
    }

    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllTouristAttraction(){
        List<TouristAttraction> allTouristAttractions = touristService.viewAll();
        return new ResponseEntity<>(allTouristAttractions, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<TouristAttraction> getTouristAttraction(@PathVariable int id){
       TouristAttraction viewTouristAttraction = touristService.view(id);

       if (viewTouristAttraction == null){
           return new ResponseEntity<>(viewTouristAttraction, HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(viewTouristAttraction, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TouristAttraction> create(@RequestBody TouristAttraction touristAttraction){
       TouristAttraction createdTouristAttraction = touristService.create(touristAttraction);
        return new ResponseEntity<>(createdTouristAttraction, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TouristAttraction> update(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction updatedTouristAttraction = touristService.update(touristAttraction);

        if (updatedTouristAttraction == null){
            return new ResponseEntity<>(updatedTouristAttraction, HttpStatus.NOT_FOUND);

        }else
            return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<TouristAttraction> delete(@PathVariable int id){
        TouristAttraction deletedTouristAttraction = touristService.delete(id);

        if(deletedTouristAttraction == null){
            return new ResponseEntity<>(deletedTouristAttraction, HttpStatus.NOT_FOUND);

        } else
            return new ResponseEntity<>(deletedTouristAttraction, HttpStatus.OK);
    }
}
