package models;

public record UserForRegistration(
        String name,
        String address,
        String phone,
        String email,
        String userName,
        String password
){}