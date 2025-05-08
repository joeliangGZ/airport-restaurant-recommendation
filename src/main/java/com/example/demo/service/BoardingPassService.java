package com.example.demo.service;

import com.example.demo.dto.BoardingPass;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardingPassService {

    private final ResourceLoader loader;

    public BoardingPass parseBoardingPass(String imageName) {
        // —— 伪代码示例 ——
        // String ocrResult = ocrClient.recognizeText(imageName);
        // String religion = parseReligion(ocrResult);
        // String airport = parseAirport(ocrResult);
        // LocalDateTime departureTime = parseDepartureTime(ocrResult);
        // String userName = parseUserName(ocrResult);

        if ("leo.png".equalsIgnoreCase(imageName)) {
            BoardingPass boardingPass = new BoardingPass();
            boardingPass.setPassengerName("LEO");
            boardingPass.setDeparture("GZ");
            boardingPass.setDestination("SH");
            boardingPass.setDepartureTime(LocalDateTime.of(2025, 6, 3, 20, 0, 0));
            boardingPass.setConfirmationNumber("IS483LL3");
            boardingPass.setGate("N64");
            boardingPass.setSeat("1D");
            boardingPass.setBoardingGroup(1);
            return boardingPass;
        } else if ("jackie.png".equalsIgnoreCase(imageName)) {
            BoardingPass boardingPass = new BoardingPass();
            boardingPass.setPassengerName("JACKIE");
            boardingPass.setDeparture("GZ");
            boardingPass.setDestination("BJ");
            boardingPass.setDepartureTime(LocalDateTime.of(2025, 7, 2, 11, 0, 0));
            boardingPass.setConfirmationNumber("IS483LL3");
            boardingPass.setGate("N64");
            boardingPass.setSeat("2C");
            boardingPass.setBoardingGroup(1);
            return boardingPass;
        } else if ("john_doe.png".equalsIgnoreCase(imageName)) {
            BoardingPass boardingPass = new BoardingPass();
            boardingPass.setPassengerName("JOHN_DOE");
            boardingPass.setDeparture("GZ");
            boardingPass.setDestination("CS");
            boardingPass.setDepartureTime(LocalDateTime.of(2025, 8, 4, 16, 0, 0));
            boardingPass.setConfirmationNumber("IS483LL3");
            boardingPass.setGate("N64");
            boardingPass.setSeat("1E");
            boardingPass.setBoardingGroup(1);
            return boardingPass;
        } else {
            return null;
        }
    }

//    private List<BoardingPass> loadBoardingPassList() throws IOException {
//        ObjectMapper mapper = JacksonConfig.createObjectMapper();
//        Resource resource = loader.getResource("classpath:static/religion.json");
//        return mapper.readValue(resource.getInputStream(), new TypeReference<List<BoardingPass>>() {});
//    }
//
//    private BoardingPass findByImageNamePrefixOptional(List<BoardingPass> list, String imageName) {
//        int hash = imageName.hashCode();
//        int index = Math.floorMod(hash, list.size());
//        return list.get(index);
//    }
}
