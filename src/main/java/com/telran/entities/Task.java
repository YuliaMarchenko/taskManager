package com.telran.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private boolean isCompleted;
    private String assignedPerson;
    private LocalDate createdDate;
    private LocalDate completionDate;
}

