package com.employeemanagement.models;

import org.springframework.stereotype.Component;

import com.employeemanagement.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

	Status status;
	String message;
}
