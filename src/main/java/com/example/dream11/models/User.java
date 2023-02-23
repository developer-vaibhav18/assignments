package com.example.dream11.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Document("users")
public class User {
    @Id
    private int userId;
    @NonNull
//    @Unique
    @Indexed(unique = true)
    private String email;
    @NonNull
    private String name;
    private float money;
    private List<Integer> contestIdsInWhichUserParticipated;
}
