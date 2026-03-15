package com.tms.springboottms.utils;

public record ApiResponse<T>(int status, T data) {
}