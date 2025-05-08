package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardingPass {

    private String passengerName;
    private String departure;
    private String destination;
    private String confirmationNumber;
    private LocalDateTime departureTime;
    private String gate;
    private String seat;
    private Integer boardingGroup;
}
