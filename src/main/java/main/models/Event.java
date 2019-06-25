package main.models;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull

    @Column(name = "name")
    private String name;

    @Column(name ="agenda",length = 280)
    private String agenda;

    @NotNull
    @Column(name = "date")
    private Date date;

    @NonNull
    @Column(name = "org")
    private User organizer;



}
