package zup.hackingthefire.solution.htfbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zup.hackingthefire.solution.htfbackend.model.Occurrence;
import zup.hackingthefire.solution.htfbackend.repository.OccurrenceRepository;

import java.util.List;

@Service
public class OccurrenceService {

    @Autowired
    private OccurrenceRepository repository;

    public List<Occurrence> getOccurrences(){
        return repository.findAll();
    }

    public Occurrence saveOccurrence(Occurrence occurrence){
        if(occurrence.getId() != null){
            occurrence = repository.findOne(occurrence.getId());
        }
        if(occurrence.getLatitude() == null || occurrence.getLongitude() == null){
            occurrence.setCoordinatesFromOccurrance();
        }
        return repository.save(occurrence);
    }

    public Occurrence findOccurrenceById(String id){
        return repository.findOne(id);
    }

    public List<Occurrence> findOccurrenceByStatus(Occurrence.OccurrenceStatus occurrenceStatus){
        return repository.findByOccurrenceStatus(occurrenceStatus);
    }

    public List<Occurrence> findUrgentOccurrencies(Boolean isEmergency){
        return repository.findByIsEmergency(isEmergency);
    }

}
