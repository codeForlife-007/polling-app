package com.voting.votingapp.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Embeddable
public class OptionVote {
    @NotEmpty(message = "Option text cannot be empty")
    private String optionText;
    private Long voteCount = 0L;
}
