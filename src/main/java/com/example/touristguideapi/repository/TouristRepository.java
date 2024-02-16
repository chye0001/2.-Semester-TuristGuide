package com.example.touristguideapi.repository;

import com.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> database;

    public TouristRepository(){
        this.database = new ArrayList<>(List.of(
                new TouristAttraction("Sydney Opera House, New South Wales", "Mention \"Sydney, Australia\" and most people think of the Opera House. Shaped like huge shells or billowing sails, this famous building on Sydney's Bennelong Point graces the list of UNESCO World Heritage Sites and is one of the world's great architectural icons.", 1),
                new TouristAttraction("Great Barrier Reef Marine Park, Queensland", "You can't leave Australia without seeing the Great Barrier Reef. This World Heritage-listed natural wonder is one of the largest living structures on the planet. It's so vast, you can see it from outer space. For divers, snorkelers, island aficionados, and nature lovers, it's a bucket list destination.", 2),
                new TouristAttraction("Uluru-Kata Tjuta National Park, Northern Territory", "Deep in the heart of Australia's Red Centre, Uluru (formerly Ayers Rock), is one of the most photographed natural wonders in the country. The striking red monolith forms the centerpiece of Uluru-Kata Tjuta National Park, a World Heritage Site jointly managed by Parks Australia and the traditional landowners, the Aṉangu people.", 3)
        ));
    }

    public TouristAttraction view(int touristAttractionID){
        TouristAttraction viewTouristAttraction;

        try {
            for (TouristAttraction touristAttraction : database) {
                if (touristAttraction.getId() == touristAttractionID) {
                    viewTouristAttraction = touristAttraction;
                    return viewTouristAttraction;
                }
            }
            return null;

        } catch (Exception e){
            return null;
        }
    }

    public List<TouristAttraction> viewAll(){
        return database;
    }

    public TouristAttraction create(TouristAttraction touristAttraction){
        database.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction update(TouristAttraction touristAttraction){
        TouristAttraction updatedTouristAttraction = null;

        for (int i = 0; i < database.size(); i++) {
            if (touristAttraction.getId() == (database.get(i).getId())){
                updatedTouristAttraction = touristAttraction;
                database.set(i, updatedTouristAttraction);
                break;
            }
        }

        return updatedTouristAttraction;
    }

    public TouristAttraction delete(int touristAttractionID){
        TouristAttraction touristAttractionToDelete = null;

        for (int i = 0; i < database.size(); i++) {
            if (touristAttractionID == database.get(i).getId()){
                touristAttractionToDelete = database.get(i);
                database.remove(touristAttractionToDelete);
                break;
            }
        }

        return touristAttractionToDelete;
    }
}
