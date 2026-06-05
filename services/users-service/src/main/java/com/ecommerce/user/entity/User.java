package com.ecommerce.user.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase; // <-- Mudou aqui!
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import io.quarkus.elytron.security.common.BcryptUtil;

@Entity
@Table(name = "users")
public class User extends PanacheEntityBase { 

    @Id
    @SequenceGenerator(
            name = "userSeqGen", 
            sequenceName = "user_seq", // 
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeqGen")
    public Long id; 

    public String name;
    
    public String email;
    
    public String password; 

    @Column(name = "created_at") 
    public LocalDateTime createdAt;

    // Método para definir a senha já com hash
    public void setPassword(String plainPassword) {
        this.password = BcryptUtil.bcryptHash(plainPassword);
    }

    // Método para validar senha
    public boolean checkPassword(String plainPassword) {
        return BcryptUtil.matches(plainPassword, this.password);
    }
}