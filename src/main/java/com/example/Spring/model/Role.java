package com.example.Spring.model;

import com.example.Spring.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Role extends BaseEntity<Integer> {

    private String role;

    @ManyToMany
    private Set<Url> urls;
}
