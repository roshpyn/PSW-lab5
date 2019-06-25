package main.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table
public class UserOnEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToOne
    private Event event;

    @NonNull
    @OneToOne
    private User user;

    @NonNull
    @ManyToOne
    private FoodType foodType;

    @NonNull
    private Boolean confirmed;
}
