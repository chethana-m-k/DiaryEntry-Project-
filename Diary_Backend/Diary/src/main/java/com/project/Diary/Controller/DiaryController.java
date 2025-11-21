package com.project.Diary.Controller;


import com.project.Diary.Model.DiaryEntryModel;
import com.project.Diary.Service.DiaryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryEntryService diaryEntryService;



    @PostMapping(value = "/save", consumes = "multipart/form-data")
    public DiaryEntryModel saveEntry(
            @RequestParam String name,
            @RequestParam String entryDate,
            @RequestParam String entryTime,
            @RequestParam String entryDay,
            @RequestParam String title,
            @RequestParam String whatIDid,
            @RequestParam String plans,
            @RequestParam(required = false) MultipartFile attachments
    ) throws Exception {

        return diaryEntryService.saveDiaryEntry(
                name,
                entryDate,
                entryTime,
                entryDay,
                title,
                whatIDid,
                plans,
                attachments
        );
    }


    // Display all entries
    @GetMapping("/all")
    public List<DiaryEntryModel> getAllEntries() {
        return diaryEntryService.getAllEntries();
    }



    // GET BY ID
    @GetMapping("/{id}")
    public DiaryEntryModel getEntry(@PathVariable String id) {
        return diaryEntryService.getEntryById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public DiaryEntryModel updateEntry(@PathVariable String id, @RequestBody DiaryEntryModel updatedEntry) {
        return diaryEntryService.updateEntry(id, updatedEntry);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteEntry(@PathVariable String id) {
        return diaryEntryService.deleteEntry(id);
    }






}
