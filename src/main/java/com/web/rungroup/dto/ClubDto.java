package com.web.rungroup.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ClubDto {
    private long id;

    private String title;
    private String photoUrl;
    private String content;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
