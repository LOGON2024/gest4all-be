package com.logon.gest4all.entities;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    private String address;
    private String postalCode;
    private String city;
}
