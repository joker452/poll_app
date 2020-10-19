package com.b1deng.poll.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.annotation.processing.AbstractProcessor;
import javax.validation.Valid;

@Getter
@Setter
@Valid
@Validated
public class ChoiceVoteCount {
    private Long choiceId;
    private Long voteCount;

    public ChoiceVoteCount(Long choiceId, Long voteCount) {
        this.choiceId = choiceId;
        this.voteCount = voteCount;
    }

}