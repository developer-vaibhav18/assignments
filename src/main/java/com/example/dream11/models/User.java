package com.example.dream11.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String name;
    private float money;
    private List<Integer> IdsOfContestsInWhichUserParticipated;
}
