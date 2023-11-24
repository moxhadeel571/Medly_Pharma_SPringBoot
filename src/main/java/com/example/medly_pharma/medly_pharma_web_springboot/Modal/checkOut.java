    package com.example.medly_pharma.medly_pharma_web_springboot.Modal;

    import lombok.*;
    import org.bson.types.ObjectId;
    import org.springframework.data.mongodb.core.mapping.DBRef;
    import org.springframework.data.mongodb.core.mapping.Document;
    import org.springframework.data.mongodb.core.mapping.Field;
    import org.springframework.data.mongodb.core.mapping.MongoId;

    import java.util.Date;
    import java.util.List;
    import java.util.Optional;

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Setter
    @Data
    @Document(collection = "checkOut")
    public class checkOut {
        @MongoId
        private ObjectId id;
        @DBRef
        private UserInfo userInfo;
        private boolean processed;
        private Boolean sameAddress;
        private Double totalAmount;
       private  List<Medicine> orderitem;
        private Boolean saveInfo;
        private Double savedAmount;
        private Integer TotalItems;
        private Coupon coupon;
        private Date Orderdate;
        private List<String> productNames;

    }
