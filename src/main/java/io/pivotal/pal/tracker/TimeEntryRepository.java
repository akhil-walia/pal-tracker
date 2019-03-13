package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class TimeEntryRepository {
    public ResponseEntity<TimeEntry> delete(long timeEntryId) {
    }

    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
    }

    public ResponseEntity<List<TimeEntry>> list() {
    }

    public void find(long nonExistentTimeEntryId) {
    }

    public ResponseEntity create(TimeEntry any) {
    }
}
