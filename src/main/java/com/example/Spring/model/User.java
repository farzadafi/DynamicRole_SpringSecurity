package com.example.Spring.model;

import com.example.Spring.model.base.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "Users")
public class User extends BaseEntity<Integer> {

    private String firstname;
    private String lastname;
    private String username;
    private String password;

    @CreationTimestamp
    private OffsetDateTime creationDate;

    @ManyToOne
    private Role role;
}
