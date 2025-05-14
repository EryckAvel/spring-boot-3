package com.eryckavel.spring_boot_3.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
