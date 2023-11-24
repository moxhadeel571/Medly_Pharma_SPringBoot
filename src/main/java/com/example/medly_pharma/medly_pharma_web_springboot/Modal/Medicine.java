package com.example.medly_pharma.medly_pharma_web_springboot.Modal;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Document(collection = "Medicines")
public class Medicine {
@MongoId
    private ObjectId id;
    private String subCategory;
    private String product_name;
    private String saltComposition;
    private String product_manufactured;
    @DBRef
    private checkOut checkout;

    private String product_price;
    private String medicine_desc;
    private String side_effects;
    private DrugInteractions drugInteractions;

    @Data
    public static class Id {
        private String oid;
    }

    @Data
    public static class DrugInteractions {
        private List<String> drug;
        private List<String> brand;
        private List<String> effect;
    }
}
