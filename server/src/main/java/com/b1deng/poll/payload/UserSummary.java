package com.b1deng.poll.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserSummary {
    private Long id;
    private String username;
    private String name;
}
