package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {


    private HashMap<Long, TimeEntry> map = new HashMap();
    private Long timeEntryID = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntryToCreate) {
        long currentId = timeEntryID++;
        TimeEntry timeEntry = new TimeEntry(currentId, timeEntryToCreate.getProjectId(), timeEntryToCreate.getUserId(), timeEntryToCreate.getDate(), timeEntryToCreate.getHours());
        map.put(currentId, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry delete(long timeEntryId) {
        TimeEntry TimeEntry =  map.remove(timeEntryId);
        return null;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry timeEntry1 = map.get(id);

        if(null == timeEntry1){
            return null;
        }

        timeEntry1.setProjectId(timeEntry.getProjectId());
        timeEntry1.setUserId(timeEntry.getUserId());
        timeEntry1.setDate(timeEntry.getDate());
        timeEntry1.setHours(timeEntry.getHours());
        return timeEntry1;
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(map.values());
    }

    @Override
    public TimeEntry find(long id) {
        return map.get(id);
    }


}
