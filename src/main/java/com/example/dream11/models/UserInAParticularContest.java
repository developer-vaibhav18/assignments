package com.example.dream11.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInAParticularContest {

    private int id;
    private int contestId;
    private int userId;
    private List<Integer> playerIdsOfPlayersChosen;
}
