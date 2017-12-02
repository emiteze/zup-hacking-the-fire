package zup.hackingthefire.solution.htfbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.hackingthefire.solution.htfbackend.constants.Constants;
import zup.hackingthefire.solution.htfbackend.model.Occurrence;
import zup.hackingthefire.solution.htfbackend.service.OccurrenceService;

@RestController
@RequestMapping("/occurrences")
public class OccurrenceController {

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
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
