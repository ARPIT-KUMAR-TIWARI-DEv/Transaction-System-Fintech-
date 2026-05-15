
package com.arpit.pfms.dto;

public class AuthResponse {

    private String token;
    private String message;
    private Long userId;
    private String name;
    private String email;

    // No-Args Constructor
    public AuthResponse() {
    }

    // All-Args Constructor
    public AuthResponse(String token, String message, Long userId, String name, String email) {
        this.token = token;
        this.message = message;
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // Getter and Setter for token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter and Setter for userId
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
