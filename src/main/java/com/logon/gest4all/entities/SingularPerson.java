package com.logon.gest4all.entities;

import com.logon.gest4all.entities.enums.ClientState;
import com.logon.gest4all.entities.enums.DeletedState;
import com.logon.gest4all.entities.enums.MaritalStatus;
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
@Table(name = "singular_person")
public class SingularPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer nif;
    @NotNull
    private String placeOfBirth;
    @NotNull
    private String address;
    @NotNull
    private String postalCode;
    @NotNull
    private String city;
    @NotNull
    private LocalDateTime start;
    private LocalDateTime end;
    @NotNull
    private DeletedState deletedState;
    @NotNull
    private MaritalStatus maritalStatus;
    @NotNull
    private ClientState clientState;
}
