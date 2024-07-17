package ru.gb.timesheet.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


//Конфигурационный класс, форматируем LocalDate в ISO-формат YYYY-mm-dd (например,2024-07-10)

@Configuration
public class JacksonConfig {
//    // Форматируем LocalDate в формат dd-mm-YYYY (например, 10-07-2024)
//    private static final String DATE_FORMAT = "dd-MM-yyyy";
//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    
    @Bean
    public ObjectMapper objectMapper() {
      
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
        
//        // Форматируем LocalDate в формат dd-mm-YYYY (например, 10-07-2024)
//        ObjectMapper mapper = new ObjectMapper();
//        JavaTimeModule javaTimeModule = new JavaTimeModule();
//        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DATE_FORMATTER));
//        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DATE_FORMATTER));
//        mapper.registerModule(javaTimeModule);
//        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        return mapper;
        
    }
}
