package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry delete(long timeEntryId);

    TimeEntry update(long id, TimeEntry timeEntry);

    List<TimeEntry> list();

    TimeEntry find(long id) ;

    TimeEntry create(TimeEntry timeEntry);
}
