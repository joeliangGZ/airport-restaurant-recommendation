package com.example.demo.service;

import com.example.demo.config.JacksonConfig;
import com.example.demo.dto.BoardingPassInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardingPassService {

    private final ResourceLoader loader;

    public BoardingPassInfo parseBoardingPass(String imageName) {
        // —— 伪代码示例 ——
        // String ocrResult = ocrClient.recognizeText(imageName);
        // String religion = parseReligion(ocrResult);
        // String airport = parseAirport(ocrResult);
        // LocalDateTime departureTime = parseDepartureTime(ocrResult);
        // String userName = parseUserName(ocrResult);

        try {
            List<BoardingPassInfo> list = loadBoardingPassList();
            return findByImageNamePrefixOptional(list, imageName);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private List<BoardingPassInfo> loadBoardingPassList() throws IOException {
        ObjectMapper mapper = JacksonConfig.createObjectMapper();
        Resource resource = loader.getResource("classpath:static/religion.json");
        return mapper.readValue(resource.getInputStream(), new TypeReference<List<BoardingPassInfo>>() {});
    }

    private BoardingPassInfo findByImageNamePrefixOptional(List<BoardingPassInfo> list, String imageName) {
        int hash = imageName.hashCode();
        int index = Math.floorMod(hash, list.size());
        return list.get(index);
    }
}
