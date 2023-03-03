package com.example.dream11.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("myPairs")
@AllArgsConstructor
@NoArgsConstructor
public class TestPlayerSkills {
    String skillName;
    Boolean primary;
}
