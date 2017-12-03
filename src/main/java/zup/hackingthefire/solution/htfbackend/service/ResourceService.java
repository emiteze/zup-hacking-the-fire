package zup.hackingthefire.solution.htfbackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zup.hackingthefire.solution.htfbackend.model.Occurrence;
import zup.hackingthefire.solution.htfbackend.model.Resource;
import zup.hackingthefire.solution.htfbackend.repository.ResourceRepository;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository repository;

    @Autowired
    private OccurrenceService occurrenceService;

    private static final Logger logger = LoggerFactory.getLogger(OccurrenceService.class);

    public List<Resource> getResources(){
        return repository.findAll();
    }

    public Resource saveResource(Resource resource){
        return repository.save(resource);
    }

    public Resource findByResourceToken(String resourceToken){
        return repository.findByResourceToken(resourceToken);
    }

    public List<Resource> findByResourceType(String resourceType){
        return repository.findByResourceType(resourceType);
    }

    public List<Resource> findByResourceStatus(Resource.ResourceStatus resourceStatus){
        return repository.findByResourceStatus(resourceStatus);
    }

    public Occurrence setAvailability(Resource resource){

        Occurrence occurrence = null;
        Resource resourceInBd = repository.findByResourceToken(resource.getResourceToken());

        if(null != resourceInBd && !resourceInBd.getOccurrenceId().equals(null)){
            occurrence = occurrenceService.findOccurrenceById(resourceInBd.getOccurrenceId());
        }

        return occurrence;

    }

    public void setUnavailability(Resource resource){
        repository.delete(resource.getId());
    }

}
