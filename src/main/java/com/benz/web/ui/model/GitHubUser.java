package com.benz.web.ui.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GitHubUser {
    private String userName;
    private String id;
    private String name;
    private String type;
    private String location;
    private String bio;
    private String createdAt;
}
