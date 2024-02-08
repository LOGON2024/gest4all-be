package com.logon.gest4all.entities;

import com.logon.gest4all.entities.enums.DeletedState;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "collective_person")
public class CollectivePerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer nipc;
    @NotNull
    private Integer commercialPermanentCertificateCode;
    @NotNull
    private Address address;
    @NotNull
    private LocalDateTime start;
    @NotNull
    private LocalDateTime end;
    @NotNull
    private DeletedState deletedState;
    private SingularPerson legalRepresentative;
}
