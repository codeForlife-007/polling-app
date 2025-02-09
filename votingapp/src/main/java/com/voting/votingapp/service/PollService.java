package com.voting.votingapp.service;

import com.voting.votingapp.dto.PollDto;
import com.voting.votingapp.exception.DataValidationException;
import com.voting.votingapp.exception.NotFoundException;
import com.voting.votingapp.model.OptionVote;
import com.voting.votingapp.model.Poll;
import com.voting.votingapp.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class PollService {

    private PollRepository pollRepository;
    private static final Logger logger = Logger.getLogger(PollService.class.getName());

    public Poll createPoll(PollDto pollDto) throws DataValidationException {
        pollDto.validate();
        Poll poll =  pollDto.toEntity();
        poll.setQuestion(pollDto.getQuestion());
        poll.setOptions(pollDto.getOptions());
        logger.info("Options: " + pollDto.getOptions());
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Poll getPollById(Long id) throws NotFoundException {
        return pollRepository.findById(id).orElseThrow(() -> new NotFoundException("Poll not found", "Check the provided poll"));
    }

    public void vote(Long pollId, int optionIndex) throws NotFoundException, DataValidationException {
        // Get Poll from DB
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new NotFoundException("poll not found", "Check the provided poll"));

        // Get All Options
        List<OptionVote> options = poll.getOptions();

        // If index for vote is not valid, throw error
        if (optionIndex < 0 || optionIndex >= options.size()) {
            throw new DataValidationException("Invalid option index", "size exceeds than available options");
        }

        // Get Selected Option
        OptionVote selectedOption = options.get(optionIndex);

        // Increment vote for selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        // Save incremented option into the database
        pollRepository.save(poll);
    }
}
