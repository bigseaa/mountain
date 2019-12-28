package com.sea.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "demo")
public class DemoDomain implements Serializable {
    private static final long sserialVersionUID = 654657954135749798L;

    @Id
    private long id;

    private String name;
}
