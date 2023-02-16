package com.example.dream11.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contest {
    private int contestId;
    private String contestName;
    private int matchId;
    static final int maxPointsAUserHaveToCreateAContest = 100;
    private int prizePool;
    private int entryPriceForEachUser;
    private int maxNumberOfUsers;
    private int minNumberOfUsers;
    private int numberOfWinners;
    private int numberOfParticipants;
    private boolean contestIsCurrentlyLive;
    private ArrayList<Integer> userIDs;
}
