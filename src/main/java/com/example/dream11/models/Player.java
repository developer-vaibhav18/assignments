package com.example.dream11.models;

import com.example.dream11.enums.PlayerIdentity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private int playerId;
    private String name;
    private PlayerIdentity playerIdentity;
    private Map<Integer, Integer> mapOfContestIdToPointsEarned;
}
