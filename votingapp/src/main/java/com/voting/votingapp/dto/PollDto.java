package com.voting.votingapp.dto;

import com.voting.votingapp.model.OptionVote;
import com.voting.votingapp.model.Poll;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PollDto {

    private String question;
    private List<OptionVote> options = new ArrayList<>();

    // method to convert dto to entity
    public Poll toEntity() {
        Poll poll = new Poll();
        poll.setQuestion(getQuestion());
        poll.setOptions(getOptions());
        return poll;
    }
}
