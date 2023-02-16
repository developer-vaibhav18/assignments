package com.example.dream11.models;

import com.example.dream11.enums.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    private int matchID;
    private int team1Id, team2Id;
    private List<Integer> idsOfAllTheContestInThisMatch;
    private MatchStatus matchStatus;
    private MatchResult matchResult;
}
