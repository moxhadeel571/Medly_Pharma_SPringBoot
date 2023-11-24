    package com.example.medly_pharma.medly_pharma_web_springboot.ServiceImplementation;
    import com.example.medly_pharma.medly_pharma_web_springboot.Service.*;
    import com.example.medly_pharma.medly_pharma_web_springboot.Repository.*;
    import com.example.medly_pharma.medly_pharma_web_springboot.Modal.*;
    import org.thymeleaf.TemplateEngine;

    import org.bson.types.ObjectId;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.mongodb.core.MongoTemplate;
    import org.springframework.data.mongodb.core.query.Criteria;
    import org.springframework.data.mongodb.core.query.Query;
    import org.springframework.stereotype.Service;


    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    @Service
    public class checkOutServiceImpl implements checkOutService {
        private final TemplateEngine templateEngine;
        @Autowired
        private checkOutRepository checkOutRepository;
        private ProductRepository productRepository;
        private productService ProductsService;
        private OrderService OrderService;
        private final MongoTemplate mongoTemplate;
        private PromocodeRepo promocodeRepo;
        private UserInfoService userInfoService;
        private final checkOutRepository orderRepository;
        private UserInfoRepository userInfoRepository;

        private final productService productsService;
        @Autowired
        public checkOutServiceImpl(TemplateEngine templateEngine, MongoTemplate mongoTemplate,
                                   PromocodeRepo promocodeRepo , ProductRepository productRepository, checkOutRepository orderRepository,
                                   UserInfoRepository userInfoRepository, productService productsService) {
            this.templateEngine = templateEngine;
            this.mongoTemplate = mongoTemplate;
            this.promocodeRepo = promocodeRepo;
            this.productRepository = productRepository;
            this.orderRepository = orderRepository;
            this.userInfoRepository = userInfoRepository;
            this.productsService = productsService; // Injected ProductsService
        }
        @Override
        public String processOrder(ObjectId id) {
            // Retrieve the checkOut object by its ID
            checkOut checkOutObject = checkOutRepository.findById(id).orElse(null);

            if (checkOutObject != null) {
                // Check if the order has already been processed (you may need to add a flag in your checkOut class)
                if (!checkOutObject.isProcessed()) {
                    // Perform order processing logic here
                    // For example, update the order status, send confirmation emails, update product quantities, etc.

                    // Update the order as processed
                    checkOutObject.setProcessed(true);
                    checkOutRepository.save(checkOutObject);

            } else {
                // Handle the case where the order with the given ID was not found
                return ("Order with ID " + id + " not found.");
            }
        }
            return null;
        }
        @Override
        public List<checkOut> getAllCustomers() {
            // You can modify the query to match your specific criteria
            Query query = new Query();
            List<checkOut> checkOutList = mongoTemplate.find(query, checkOut.class);
            return checkOutList;
        }

        @Override
        public checkOut saveCheckout(ObjectId id,checkOut checkOut, UserInfo userInfo) throws Exception {

//            checkOut.getUserInfo().setFirstName(userInfo.getFirstName());
//            checkOut.getUserInfo().setLastName(userInfo.getLastName());
//            checkOut.getUserInfo().setUsername(userInfo.getUsername());
//            checkOut.getUserInfo().setEmail(userInfo.getEmail());
//            checkOut.getUserInfo().setPhone(userInfo.getPhone());
//            checkOut.getUserInfo().setAddressLine1(userInfo.getAddressLine1());
//            checkOut.getUserInfo().setAddressLine2(userInfo.getAddressLine2());
//            checkOut.getUserInfo().setCountry(userInfo.getCountry());
//            checkOut.getUserInfo().setCity(userInfo.getCity());
//            checkOut.getUserInfo().setState(userInfo.getState());
//            checkOut.getUserInfo().setZipcode(userInfo.getZipcode());
            checkOut.setUserInfo(userInfo);

                // Set UserInfo in checkOut

                List<String> productNames = new ArrayList<>();
                List<Medicine> cartItems = productRepository.findAll();
                for (Medicine item : cartItems) {
                    productNames.add(item.getProduct_name());
                }

                checkOut.setProductNames(productNames);
                checkOut.setOrderdate(new Date()); // Set the order date






                // Now, save the checkOut object with associated UserInfo
                return checkOutRepository.save(checkOut);

        }

        private Double calculateDiscountedPrice(Double totalAmount, Double discountPercentage) {
            // Apply the discount percentage to the total amount
            Double discountAmount = (totalAmount * discountPercentage) / 100;
            Double newTotalSum = totalAmount - discountAmount;
            return newTotalSum;
        }



        @Override
        public checkOut getAllCustomers(ObjectId id) {
            Query query = new Query(Criteria.where("_id").is(id));
            checkOut checkOutObject = mongoTemplate.findOne(query, checkOut.class);
            return checkOutObject;
        }






    }


