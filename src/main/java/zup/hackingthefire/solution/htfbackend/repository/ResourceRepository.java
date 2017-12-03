package zup.hackingthefire.solution.htfbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zup.hackingthefire.solution.htfbackend.model.Resource;
import java.util.List;

public interface ResourceRepository extends MongoRepository<Resource, String> {

    public Resource findByResourceToken(String resourceToken);

    public List<Resource> findByResourceType(String resourceType);

    public List<Resource> findByResourceStatus(Resource.ResourceStatus resourceStatus);

}
