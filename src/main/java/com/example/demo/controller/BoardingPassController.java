package com.example.demo.controller;

import com.example.demo.dto.BoardingPass;
import com.example.demo.dto.BoardingPassReq;
import com.example.demo.service.BoardingPassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boarding-pass")
public class BoardingPassController {

    private final BoardingPassService boardingPassService;

    @GetMapping
    public ResponseEntity<BoardingPass> getByImageName(@RequestParam("imageName") String imageName) {
        BoardingPass info = boardingPassService.parseBoardingPass(imageName);
        return ResponseEntity.ok(info);
    }

    @PostMapping
    public ResponseEntity<BoardingPass> postByImageName(@RequestBody BoardingPassReq req) {
        BoardingPass info = boardingPassService.parseBoardingPass(req.getImageName());
        return ResponseEntity.ok(info);
    }

}


