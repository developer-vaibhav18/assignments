package com.example.dream11.models;

import com.example.dream11.enums.WinByRunOrWickets;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MatchResult {
    private int marginOfVictory;
    private int matchId;
    private int teamIdOfWinningTeam;
    private WinByRunOrWickets winByRunOrWickets;
    public String getResult() {
        return "MatchResult{" +
                ", teamIdOfWinningTeam=" + teamIdOfWinningTeam +
                "marginOfVictory=" + marginOfVictory +
                ", winByRunOrWickets=" + winByRunOrWickets +
                '}';
    }

}
