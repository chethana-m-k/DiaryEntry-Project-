package com.project.Diary.Service;


import com.project.Diary.Model.DiaryEntryModel;
import com.project.Diary.Repository.DiaryEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class DiaryEntryService {

    private final DiaryEntryRepository diaryEntryRepository;

    public DiaryEntryService(DiaryEntryRepository diaryRepository) {
        this.diaryEntryRepository = diaryRepository;
    }

    public DiaryEntryModel saveDiaryEntry(
            String name,
            String entryDate,
            String entryTime,
            String entryDay,
            String title,
            String whatIDid,
            String plans,
            MultipartFile attachments
    ) throws Exception {

        String filePath = null;

        // Save uploaded file locally
        if (attachments != null && !attachments.isEmpty()) {
            String uploadDir = "uploads/";
            File folder = new File(uploadDir);
            if (!folder.exists()) folder.mkdirs();

            filePath = uploadDir + attachments.getOriginalFilename();
            attachments.transferTo(new File(filePath));
        }

        DiaryEntryModel entry = DiaryEntryModel.builder()
                .name(name)
                .entryDate(entryDate)
                .entryTime(entryTime)
                .entryDay(entryDay)
                .title(title)
                .whatIDid(whatIDid)
                .plans(plans)
                .build();

        return diaryEntryRepository.save(entry);
    }

    public List<DiaryEntryModel> getAllEntries() {
        return diaryEntryRepository.findAll();
    }


    // GET BY ID
    public DiaryEntryModel getEntryById(String id) {
        return diaryEntryRepository.findById(id).orElse(null);
    }

    // UPDATE
    public DiaryEntryModel updateEntry(String id, DiaryEntryModel updatedEntry) {
        DiaryEntryModel existing = diaryEntryRepository.findById(id).orElse(null);

        if (existing == null)
            return null;

        existing.setName(updatedEntry.getName());
        existing.setEntryDate(updatedEntry.getEntryDate());
        existing.setEntryTime(updatedEntry.getEntryTime());
        existing.setEntryDay(updatedEntry.getEntryDay());
        existing.setTitle(updatedEntry.getTitle());
        existing.setWhatIDid(updatedEntry.getWhatIDid());
        existing.setPlans(updatedEntry.getPlans());

        return diaryEntryRepository.save(existing);
    }

    // DELETE
    public String deleteEntry(String id) {
        diaryEntryRepository.deleteById(id);
        return "Entry deleted successfully";
    }
}
