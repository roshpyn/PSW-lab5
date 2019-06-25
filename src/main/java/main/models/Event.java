package main.models;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull

    @Column(name = "name")
    private String name;

    @Column(name ="agenda",length = 280)
    private String agenda;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NonNull
    @Column(name = "org")
    private User organizer;



}
