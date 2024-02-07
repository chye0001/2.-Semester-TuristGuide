package com.example.touristguideapi.service;

import com.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Service;
import com.example.touristguideapi.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {

    private TouristRepository touristRepository = new TouristRepository();

    public TouristAttraction view(int touristAttractionID){
        TouristAttraction viewAttraction;
        viewAttraction = touristRepository.view(touristAttractionID);

        return viewAttraction;
    }

    public List<TouristAttraction> viewAll(){
        return touristRepository.viewAll();
    }

    public TouristAttraction create(TouristAttraction touristAttraction){
        return touristRepository.create(touristAttraction);
    }

    public TouristAttraction update(TouristAttraction touristAttraction){
       return touristRepository.update(touristAttraction);
    }

    public TouristAttraction delete(int touristAttractionID){
       return touristRepository.delete(touristAttractionID);
    }
}
