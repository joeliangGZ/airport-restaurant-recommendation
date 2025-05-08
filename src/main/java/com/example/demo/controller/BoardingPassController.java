package com.example.demo.controller;

import com.example.demo.dto.BoardingPassInfo;
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
    public ResponseEntity<BoardingPassInfo> getByImageName(@RequestParam("imageName") String imageName) {
        BoardingPassInfo info = boardingPassService.parseBoardingPass(imageName);
        return ResponseEntity.ok(info);
    }

    @PostMapping
    public ResponseEntity<BoardingPassInfo> postByImageName(@RequestBody BoardingPassReq req) {
        BoardingPassInfo info = boardingPassService.parseBoardingPass(req.getImageName());
        return ResponseEntity.ok(info);
    }

}


