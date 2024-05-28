package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import utils.DataDeserializer;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class User {
    public String name;
    public String job;
    public String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @JsonDeserialize(using = DataDeserializer.class)
    public OffsetDateTime createdAt;
}
