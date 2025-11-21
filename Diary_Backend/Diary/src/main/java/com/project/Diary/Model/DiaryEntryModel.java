package com.project.Diary.Model;



import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "diaryEntries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryEntryModel {

    @Id
    private String id;

    private String name;
    private String entryDate;
    private String entryTime;
    private String entryDay;

    private String title;
    private String whatIDid;
    private String plans;

}
