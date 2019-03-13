package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class TimeEntryController {
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
    }

    public ResponseEntity<TimeEntry> delete(long timeEntryId) {
    }

    public ResponseEntity update(long nonExistentTimeEntryId, TimeEntry timeEntry) {
    }

    public ResponseEntity<List<TimeEntry>> list() {
    }

    public ResponseEntity<TimeEntry> read(long nonExistentTimeEntryId) {
    }

    public ResponseEntity create(TimeEntry timeEntryToCreate) {
    }
}
