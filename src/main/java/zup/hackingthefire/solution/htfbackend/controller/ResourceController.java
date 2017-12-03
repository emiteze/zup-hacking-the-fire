package zup.hackingthefire.solution.htfbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.hackingthefire.solution.htfbackend.constants.Constants;
import zup.hackingthefire.solution.htfbackend.model.Resource;
import zup.hackingthefire.solution.htfbackend.service.ResourceService;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class ResourceController {

    private static final Logger logger = LoggerFactory.getLogger(OccurrenceController.class);

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/get-resources", method = RequestMethod.GET)
    public ResponseEntity<?> getResources(){
        try{
            return ResponseEntity.ok(resourceService.getResources());
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.GENERAL_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/save-resource", method = RequestMethod.POST)
    public ResponseEntity<?> saveResource(@RequestBody Resource resource){
        try{
            resourceService.saveResource(resource);
            return ResponseEntity.ok(Constants.SUCCESS_SAVING_RESOURCE);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.ERROR_SAVING_RESOURCE);
        }
    }

    @RequestMapping(value = "/set-availability", method = RequestMethod.POST)
    public ResponseEntity<?> setAvailability(@RequestBody Resource resource){
        try{
            return ResponseEntity.ok(resourceService.setAvailability(resource));
        } catch(Exception e){
            logger.info("stack " + e.getMessage());
            return ResponseEntity.badRequest().body(Constants.ERROR_SETING_AVAILABILITY);
        }
    }

    @RequestMapping(value = "/set-unavailability", method = RequestMethod.POST)
    public ResponseEntity<?> setUnavailability(@RequestBody Resource resource){
        try{
            resourceService.setUnavailability(resource);
            return ResponseEntity.ok().body(Constants.SUCCESS_SETING_UNAVAILABILITY);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.ERROR_SETING_UNAVAILABILITY);
        }
    }

    @RequestMapping(value = "/set-occurrance-to-resource", method = RequestMethod.POST)
    public ResponseEntity<?> setOccurranceToResource(@RequestBody Resource resource){
        try{
            resourceService.saveResource(resource);
            return ResponseEntity.ok().body(Constants.SUCCESS_SETING_OCCURRANCE_TO_RESOURCE);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.ERROR_SETING_OCCURRANCE_TO_RESOURCE);
        }
    }

    @RequestMapping(value = "/get-resource-by-status", method = RequestMethod.GET)
    public ResponseEntity<?> findResourceByStatus(@RequestParam(value = "resourceStatus") Resource.ResourceStatus resourceStatus){
        try{
            return ResponseEntity.ok(resourceService.findByResourceStatus(resourceStatus));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.NOT_FOUND_RESOURCES_BY_STATUS);
        }
    }

    @RequestMapping(value = "/get-resource-by-token", method = RequestMethod.GET)
    public ResponseEntity<?> findResourceByToken(@RequestParam(value = "resourceToken") String resourceToken){
        try{
            return ResponseEntity.ok(resourceService.findByResourceToken(resourceToken));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.NOT_FOUND_RESOURCE_BY_TOKEN);
        }
    }

    @RequestMapping(value = "/get-resource-by-type", method = RequestMethod.GET)
    public ResponseEntity<?> findResourceByType(@RequestParam(value = "resourceType") String resourceType){
        try{
            return ResponseEntity.ok(resourceService.findByResourceType(resourceType));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.NOT_FOUND_RESOURCE_BY_TYPE);
        }
    }

}
