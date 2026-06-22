package com.app.user.dto;

public record UserResponse(
    Long id,
    String firstName,
    String lastName,
    String email,
    String phoneNumber
) {}