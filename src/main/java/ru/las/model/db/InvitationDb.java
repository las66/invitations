package ru.las.model.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvitationDb {

    private int id;
    private String phone;
    private int author;
    private int application;
    private LocalDateTime createdon;

}
