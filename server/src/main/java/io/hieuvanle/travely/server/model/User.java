package io.hieuvanle.travely.server.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;
}
