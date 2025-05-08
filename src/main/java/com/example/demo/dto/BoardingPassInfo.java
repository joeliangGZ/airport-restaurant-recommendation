package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardingPassInfo {

    private String religion;
    private String airport;
    private String boardingGate;
    private LocalDateTime departureTime;
    private String userName;

}
