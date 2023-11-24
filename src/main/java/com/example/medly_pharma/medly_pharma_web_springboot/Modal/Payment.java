package com.example.medly_pharma.medly_pharma_web_springboot.Modal;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "payments")
public class Payment {
    @MongoId
    private ObjectId receiptId;
    private Double amount;
    private String currency;

}
