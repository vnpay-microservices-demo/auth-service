package com.example.authenservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    @PrePersist
    public void ensureId(){
       this.id =  Objects.isNull(this.id)? UUID.randomUUID().toString():this.id;
    }

}
