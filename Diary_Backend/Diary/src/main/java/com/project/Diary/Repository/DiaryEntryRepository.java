package com.project.Diary.Repository;

import com.project.Diary.Model.DiaryEntryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiaryEntryRepository extends MongoRepository<DiaryEntryModel, String> {
}
