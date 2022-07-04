package com.example.bvnvalidation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Bvn {

    @Id
    private String Id;

    private String bvnNumber;

    private String basicDetails;

    private String imageDetail;

    public Bvn(String bvnNumber, String basicDetails, String imageDetail) {
        this.bvnNumber = bvnNumber;
        this.basicDetails = basicDetails;
        this.imageDetail = imageDetail;
    }

    public Bvn() {
    }
}
