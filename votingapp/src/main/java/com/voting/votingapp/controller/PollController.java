package com.voting.votingapp.controller;

import com.voting.votingapp.dto.PollDto;
import com.voting.votingapp.exception.DataValidationException;
import com.voting.votingapp.exception.NotFoundException;
import com.voting.votingapp.model.Poll;
import com.voting.votingapp.request.Vote;
import com.voting.votingapp.service.PollService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/polls")
@AllArgsConstructor
@CrossOrigin("*")
public class PollController {

    private PollService pollService;

    @PostMapping
    public ResponseEntity<Poll> createPoll(@Valid @RequestBody PollDto pollDto) throws DataValidationException {
        return ResponseEntity.ok(pollService.createPoll(pollDto));
    }

    @GetMapping
    public ResponseEntity<List<Poll>> getAllPolls() {
        return ResponseEntity.ok(pollService.getAllPolls());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(pollService.getPollById(id));
    }

    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote) throws NotFoundException, DataValidationException {
        pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }
}
