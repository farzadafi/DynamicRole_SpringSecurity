package com.example.Spring.model;

import com.example.Spring.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Url extends BaseEntity<Integer> {

    private String url;

    @ManyToMany(mappedBy = "urls")
    private Set<Role> role;
}
