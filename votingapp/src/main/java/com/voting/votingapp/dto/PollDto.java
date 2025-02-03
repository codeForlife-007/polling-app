package com.voting.votingapp.dto;

import com.voting.votingapp.exception.DataValidationException;
import com.voting.votingapp.model.OptionVote;
import com.voting.votingapp.model.Poll;
import com.voting.votingapp.utils.Missing;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PollDto {

    private String question;
    private List<OptionVote> options = new ArrayList<>();

    public void validate() throws DataValidationException {
        if (Missing.string(question)) {
            throw new DataValidationException("question is missing");
        }
    }

    // method to convert dto to entity
    public Poll toEntity() {
        Poll poll = new Poll();
        poll.setQuestion(getQuestion());
        poll.setOptions(getOptions());
        return poll;
    }
}
