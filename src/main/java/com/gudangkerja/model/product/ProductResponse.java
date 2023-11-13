package com.gudangkerja.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

public class ProductResponse {
    private Long id;

    private String name;

    private String desc;

    private String image;

    private Long price;

    private Long stock;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;
}
