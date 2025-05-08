package com.finsight.user_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finsight.user_service.entity.User;
import com.finsight.user_service.repositories.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Map.entry;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;

    private final RabbitTemplate rabbitTemplate;


    private final WebClient webClient;
    @Value("${app.prediction-service.url}")
    private String predictionServiceUrl;


    public UserService(RabbitTemplate rabbitTemplate, WebClient.Builder webClient) {
        this.rabbitTemplate = rabbitTemplate;

        this.webClient = webClient.baseUrl("http://nginx/predict").build();
    }

    // Create or Update a User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a User by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete a User by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Update a User with all fields
    public User updateUser(Long id, User userDetails) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();

            // Update basic fields
            user.setCreditScore(userDetails.getCreditScore());
            user.setDefaultStatus(userDetails.getDefaultStatus());
            user.setIncome(userDetails.getIncome());
            user.setSavings(userDetails.getSavings());
            user.setDebt(userDetails.getDebt());

            // Update ratio fields
            user.setrSavingsIncome(userDetails.getrSavingsIncome());
            user.setrDebtIncome(userDetails.getrDebtIncome());
            user.setrDebtSavings(userDetails.getrDebtSavings());

            // Update transaction and ratio fields for each category
            updateTransactionGroup(user, userDetails, "Groceries");
            updateTransactionGroup(user, userDetails, "Clothing");
            updateTransactionGroup(user, userDetails, "Housing");
            updateTransactionGroup(user, userDetails, "Education");
            updateTransactionGroup(user, userDetails, "Health");
            updateTransactionGroup(user, userDetails, "Travel");
            updateTransactionGroup(user, userDetails, "Entertainment");
            updateTransactionGroup(user, userDetails, "Gambling");
            updateTransactionGroup(user, userDetails, "Utilities");
            updateTransactionGroup(user, userDetails, "Tax");
            updateTransactionGroup(user, userDetails, "Fines");

            // Update categorical fields
            user.setCatGambling(userDetails.getCatGambling());
            user.setCatDebt(userDetails.getCatDebt());
            user.setCatCreditCard(userDetails.getCatCreditCard());
            user.setCatMortgage(userDetails.getCatMortgage());
            user.setCatSavingsAccount(userDetails.getCatSavingsAccount());
            user.setCatDependents(userDetails.getCatDependents());

            return userRepository.save(user);
        }
        return null; // If user doesn't exist
    }

    // Helper method to update transaction group fields
    private void updateTransactionGroup(User user, User userDetails, String category) {
        String prefix = category.toLowerCase();

        try {
            // Update transaction amounts
            user.getClass().getMethod("sett" + category + "6", Double.class).invoke(user,
                    userDetails.getClass().getMethod("gett" + category + "6").invoke(userDetails));
            user.getClass().getMethod("sett" + category + "12", Double.class).invoke(user,
                    userDetails.getClass().getMethod("gett" + category + "12").invoke(userDetails));

            // Update ratios
            user.getClass().getMethod("setr" + category, Double.class).invoke(user,
                    userDetails.getClass().getMethod("getr" + category).invoke(userDetails));
            user.getClass().getMethod("setr" + category + "Income", Double.class).invoke(user,
                    userDetails.getClass().getMethod("getr" + category + "Income").invoke(userDetails));
            user.getClass().getMethod("setr" + category + "Savings", Double.class).invoke(user,
                    userDetails.getClass().getMethod("getr" + category + "Savings").invoke(userDetails));
            user.getClass().getMethod("setr" + category + "Debt", Double.class).invoke(user,
                    userDetails.getClass().getMethod("getr" + category + "Debt").invoke(userDetails));
        } catch (Exception e) {
            // Handle reflection exceptions
            e.printStackTrace();
        }
    }

    public Map<String, Object> createPredictionRequest(User user) {
        return Map.ofEntries(
                // Key target variables
                entry("CUST_ID", user.getCustId()),
                entry("CREDIT_SCORE", user.getCreditScore()),
                entry("DEFAULT", user.getDefaultStatus()),

                // Basic financial features
                entry("INCOME", user.getIncome()),
                entry("SAVINGS", user.getSavings()),
                entry("DEBT", user.getDebt()),
                entry("R_SAVINGS_INCOME", user.getrSavingsIncome()),
                entry("R_DEBT_INCOME", user.getrDebtIncome()),
                entry("R_DEBT_SAVINGS", user.getrDebtSavings()),

                // Transaction groups (pattern for each category)
                // Groceries
                entry("T_GROCERIES_6", user.gettGroceries6()),
                entry("T_GROCERIES_12", user.gettGroceries12()),
                entry("R_GROCERIES", user.getrGroceries()),
                entry("R_GROCERIES_INCOME", user.getrGroceriesIncome()),
                entry("R_GROCERIES_SAVINGS", user.getrGroceriesSavings()),
                entry("R_GROCERIES_DEBT", user.getrGroceriesDebt()),

                // Clothing
                entry("T_CLOTHING_6", user.gettClothing6()),
                entry("T_CLOTHING_12", user.gettClothing12()),
                entry("R_CLOTHING", user.getrClothing()),
                entry("R_CLOTHING_INCOME", user.getrClothingIncome()),
                entry("R_CLOTHING_SAVINGS", user.getrClothingSavings()),
                entry("R_CLOTHING_DEBT", user.getrClothingDebt()),

                // Housing
                entry("T_HOUSING_6", user.gettHousing6()),
                entry("T_HOUSING_12", user.gettHousing12()),
                entry("R_HOUSING", user.getrHousing()),
                entry("R_HOUSING_INCOME", user.getrHousingIncome()),
                entry("R_HOUSING_SAVINGS", user.getrHousingSavings()),
                entry("R_HOUSING_DEBT", user.getrHousingDebt()),

                // Education
                entry("T_EDUCATION_6", user.gettEducation6()),
                entry("T_EDUCATION_12", user.gettEducation12()),
                entry("R_EDUCATION", user.getrEducation()),
                entry("R_EDUCATION_INCOME", user.getrEducationIncome()),
                entry("R_EDUCATION_SAVINGS", user.getrEducationSavings()),
                entry("R_EDUCATION_DEBT", user.getrEducationDebt()),

                // Healtr
                entry("T_HEALTH_6", user.gettHealth6()),
                entry("T_HEALTH_12", user.gettHealth12()),
                entry("R_HEALTH", user.getrHealth()),
                entry("R_HEALTH_INCOME", user.getrHealthIncome()),
                entry("R_HEALTH_SAVINGS", user.getrHealthSavings()),
                entry("R_HEALTH_DEBT", user.getrHealthDebt()),

                // Travel
                entry("T_TRAVEL_6", user.gettTravel6()),
                entry("T_TRAVEL_12", user.gettTravel12()),
                entry("R_TRAVEL", user.getrTravel()),
                entry("R_TRAVEL_INCOME", user.getrTravelIncome()),
                entry("R_TRAVEL_SAVINGS", user.getrTravelSavings()),
                entry("R_TRAVEL_DEBT", user.getrTravelDebt()),

                // Entertainment
                entry("T_ENTERTAINMENT_6", user.gettEntertainment6()),
                entry("T_ENTERTAINMENT_12", user.gettEntertainment12()),
                entry("R_ENTERTAINMENT", user.getrEntertainment()),
                entry("R_ENTERTAINMENT_INCOME", user.getrEntertainmentIncome()),
                entry("R_ENTERTAINMENT_SAVINGS", user.getrEntertainmentSavings()),
                entry("R_ENTERTAINMENT_DEBT", user.getrEntertainmentDebt()),

                // Gamblingx
                entry("T_GAMBLING_6", user.gettGambling6()),
                entry("T_GAMBLING_12", user.gettGambling12()),
                entry("R_GAMBLING", user.getrGambling()),
                entry("R_GAMBLING_INCOME", user.getrGamblingIncome()),
                entry("R_GAMBLING_SAVINGS", user.getrGamblingSavings()),
                entry("R_GAMBLING_DEBT", user.getrGamblingDebt()),

                // Utilities
                entry("T_UTILITIES_6", user.gettUtilities6()),
                entry("T_UTILITIES_12", user.gettUtilities12()),
                entry("R_UTILITIES", user.getrUtilities()),
                entry("R_UTILITIES_INCOME", user.getrUtilitiesIncome()),
                entry("R_UTILITIES_SAVINGS", user.getrUtilitiesSavings()),
                entry("R_UTILITIES_DEBT", user.getrUtilitiesDebt()),

                // Tax
                entry("T_TAX_6", user.gettTax6()),
                entry("T_TAX_12", user.gettTax12()),
                entry("R_TAX", user.getrTax()),
                entry("R_TAX_INCOME", user.getrTaxIncome()),
                entry("R_TAX_SAVINGS", user.getrTaxSavings()),
                entry("R_TAX_DEBT", user.getrTaxDebt()),

                // Fines
                entry("T_FINES_6", user.gettFines6()),
                entry("T_FINES_12", user.gettFines12()),
                entry("R_FINES", user.getrFines()),
                entry("R_FINES_INCOME", user.getrFinesIncome()),
                entry("R_FINES_SAVINGS", user.getrFinesSavings()),
                entry("R_FINES_DEBT", user.getrFinesDebt()),

                // Categorical features
                entry("CAT_GAMBLING", user.getCatGambling()),
                entry("CAT_DEBT", user.getCatDebt() ? 1 : 0),
                entry("CAT_CREDIT_CARD", user.getCatCreditCard() ? 1 : 0),
                entry("CAT_MORTGAGE", user.getCatMortgage() ? 1 : 0),
                entry("CAT_SAVINGS_ACCOUNT", user.getCatSavingsAccount() ? 1 : 0),
                entry("CAT_DEPENDENTS", user.getCatDependents() ? 1 : 0)
        );
    }
    public class PredictionResponse {
        private Double score;

        // Getters and setters
        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }
    }
    public class EmailRequest {
        private Long id;
        private double score;

        // Constructors
        public EmailRequest() {}

        public EmailRequest(Long id, double score) {
            this.id = id;
            this.score = score;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }
    public void sendEmailAlert(User user, double score) {
        try {
            EmailRequest request = new EmailRequest(user.getCustId(), score);
            String json = objectMapper.writeValueAsString(request);
            rabbitTemplate.convertAndSend("email-queue", json);
        } catch (Exception e) {
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }
    // Predict Credit Score using ML Model
    public double predictCreditScore(User user) {

        // Call Flask API
        Double score = null;
        try {
            Map<String, Object> request = createPredictionRequest(user);

            score = webClient.post()
                    .uri("/predict")
                    .bodyValue(user)
                    .retrieve()
                    .bodyToMono(String.class)
                    .map(response -> {
                        try {
                            return new ObjectMapper()
                                    .readTree(response)
                                    .path("score")
                                    .asDouble();
                        } catch (Exception e) {
                            throw new RuntimeException("Failed to parse response", e);
                        }
                    })
                    .block();

            // If score is low, queue an email

            sendEmailAlert(user,score);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return score;
    }

    // Predict Default Risk using ML Model
    public boolean predictDefaultRisk(User user) {
        // Placeholder for risk prediction logic
        // This can be a threshold check based on certain features (e.g., high debt)
        return true; // Placeholder
    }
}