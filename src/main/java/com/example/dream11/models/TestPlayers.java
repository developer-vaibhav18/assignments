package com.example.dream11.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("test_players")
public class TestPlayers {
    private String name;
    private List<TestPlayerSkills> skills;
}
