package io.spring.infrastructure.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue
    private Long id;
}
