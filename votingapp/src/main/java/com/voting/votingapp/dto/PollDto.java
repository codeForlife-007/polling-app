package com.voting.votingapp.dto;

import com.voting.votingapp.model.OptionVote;
import com.voting.votingapp.model.Poll;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class PollDto {

    @NotEmpty(message = "question cannot be empty")
    private String question;
    @Valid
    private List<OptionVote> options = new ArrayList<>();

    // method to convert dto to entity
    public Poll toEntity() {
        Poll poll = new Poll();
        poll.setQuestion(getQuestion());
        poll.setOptions(getOptions());
        return poll;
    }
}
