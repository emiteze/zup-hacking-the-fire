package zup.hackingthefire.solution.htfbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.hackingthefire.solution.htfbackend.constants.Constants;
import zup.hackingthefire.solution.htfbackend.model.Occurrence;
import zup.hackingthefire.solution.htfbackend.service.OccurrenceService;

@RestController
@RequestMapping("/occurrences")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class OccurrenceController {

    private static final Logger logger = LoggerFactory.getLogger(OccurrenceController.class);

    @Autowired
    private OccurrenceService occurrenceService;

    @RequestMapping(value = "/get-ocurrences", method = RequestMethod.GET)
    public ResponseEntity<?> findOccurrences(){
        try{
            return ResponseEntity.ok(occurrenceService.getOccurrences());
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.GENERAL_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/save-occurrence", method = RequestMethod.POST)
    public ResponseEntity<?> saveOccurrence(@RequestBody Occurrence occurrence){
        try{
            occurrenceService.saveOccurrence(occurrence);
            return ResponseEntity.ok(Constants.SAVED_OCCURRENCE);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(Constants.ERROR_SAVING_OCCURRENCE);
        }
    }

    @RequestMapping(value = "/get-ocurrence", method = RequestMethod.GET)
    public ResponseEntity<?> findOccurrence(@RequestParam(value = "id") String id){
        try{
            return ResponseEntity.ok(occurrenceService.findOccurrenceById(id));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.OCCURRENCE_NOT_FOUND);
        }
    }

    @RequestMapping(value = "/get-ocurrences-by-status", method = RequestMethod.GET)
    public ResponseEntity<?> findOccurrencesByStatus(@RequestParam(value = "occurrenceStatus") Occurrence.OccurrenceStatus occurrenceStatus){
        try{
            return ResponseEntity.ok(occurrenceService.findOccurrenceByStatus(occurrenceStatus));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.NOT_FOUND_OCCURRENCES_BY_STATUS);
        }
    }

    @RequestMapping(value = "/get-urgent-ocurrences", method = RequestMethod.GET)
    public ResponseEntity<?> findUrgentOccurrences(@RequestParam(value = "isEmergency") Boolean isEmergency){
        try{
            return ResponseEntity.ok(occurrenceService.findUrgentOccurrencies(isEmergency));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(Constants.NOT_FOUND_URGENT_OCCURRENCES);
        }
    }

}
