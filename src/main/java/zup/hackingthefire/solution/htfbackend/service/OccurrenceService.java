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
        return repository.save(occurrence);
    }

}
