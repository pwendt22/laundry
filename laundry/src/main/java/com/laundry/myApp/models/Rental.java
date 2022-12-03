package com.laundry.myApp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
@Getter @Setter @NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime bookedMoment;

    private LocalDateTime bookedEvent;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
