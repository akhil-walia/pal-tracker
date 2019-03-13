package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);
        if(null == timeEntry){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if(null == timeEntry){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(timeEntry, HttpStatus.OK);
    }
/*
    public ResponseEntity<TimeEntry> find(long timeEntryToFind) {
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryToFind);
        return new ResponseEntity(timeEntry,HttpStatus.OK);
    }
*/
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntry = timeEntryRepository.list();

        if(timeEntry == null){
            return new ResponseEntity<List<TimeEntry>>(timeEntry,HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<List<TimeEntry>>(timeEntry,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody TimeEntry timeEntryToUpdate) {

        TimeEntry timeEntry = timeEntryRepository.update(id, timeEntryToUpdate);
        if(null == timeEntry){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(timeEntry, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable Long id) {
        TimeEntry timeEntry = timeEntryRepository.delete(id);
            return new ResponseEntity(timeEntry, HttpStatus.NO_CONTENT);

    }









}
