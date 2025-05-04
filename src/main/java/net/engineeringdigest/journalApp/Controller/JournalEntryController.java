package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entry.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntites = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntites.values());
    }

    @PostMapping//Create new data
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntites.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("/id/{myid}")//access data of specific id
    public JournalEntry getJournalEntryById(@PathVariable Long myid){
        return journalEntites.get(myid);
    }

    @DeleteMapping("/id/{delId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long delId){
        return journalEntites.remove(delId);
    }

    @PutMapping("/id/{updId}")
    public JournalEntry updateJournalEntryById(@PathVariable Long updId,@RequestBody JournalEntry myEntry){
        return journalEntites.put(updId,myEntry);
    }
}
