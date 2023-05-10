package com.example.jpabasics.models;

import com.example.jpabasics.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Department department;

    @CreationTimestamp          // automatically assign creation date
    private Date creationDate;

    @UpdateTimestamp            // automatically update date whenever used
    private Date updationDate;


    // foreign key --> primary key of parent
    @OneToOne
    @JoinColumn         // joinColumn has default value as - it will primary key of parent as foreign key
            Student student;
}
