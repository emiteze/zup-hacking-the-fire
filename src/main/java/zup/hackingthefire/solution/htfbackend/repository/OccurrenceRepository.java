package zup.hackingthefire.solution.htfbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zup.hackingthefire.solution.htfbackend.model.Occurrence;
import java.util.List;

public interface OccurrenceRepository extends MongoRepository<Occurrence, String> {

    public List<Occurrence> findByOccurrenceStatus(Occurrence.OccurrenceStatus occurrenceStatus);

    public List<Occurrence> findByIsEmergency(Boolean isEmergency);

}
