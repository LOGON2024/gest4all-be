package com.logon.gest4all.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private Long id;
    private String email;
    private String phoneNumber;

}
