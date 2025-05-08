package com.example.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JacksonConfig {

    public static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // 注册 Java 8 日期/时间模块
        mapper.registerModule(new JavaTimeModule());                                         // :contentReference[oaicite:2]{index=2}
        // 关闭写时间戳
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);                       // :contentReference[oaicite:3]{index=3}
        // 可选：关闭失败时异常，改用 null 或默认值
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // 精细控制 LocalDateTime 反序列化格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(
                LocalDateTime.class,
                new LocalDateTimeDeserializer(formatter)
        );
        mapper.registerModule(javaTimeModule);

        return mapper;
    }
}
