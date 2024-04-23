package com.intraconnect.usermanagementms.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document
public class Token {
    @Id
    Integer id;
    private String token;
    private LocalDateTime createdAT;
    private LocalDateTime expiresAt;
    private LocalDateTime ValidedAt;
    private String userid;
}
