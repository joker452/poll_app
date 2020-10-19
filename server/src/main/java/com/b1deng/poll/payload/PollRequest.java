package com.b1deng.poll.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class PollRequest {

    @NotBlank
    @Size(max = 140)
    private String question;

    @NotNull
    @Size(min = 2, max = 6)
    @Valid
    private List<ChoiceRequest> choices;

    @NotNull
    @Valid
    private PollLength pollLength;

    @Getter
    @Setter
    public class PollLength {

        @NotNull
        @Max(7)
        private Integer days;

        @NotNull
        @Max(23)
        private Integer hours;

    }
}
