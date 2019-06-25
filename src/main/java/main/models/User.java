package main.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "login")
    private String login;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "surname")
    private String surname;

    @NonNull
    @Column(name = "permission")
    private String permission;
    public User(String login, String password, String email, String name, String surname, String permission){
        setLogin(login);
        setPassword(password);
        setEmail(email);
        setName(name);
        setSurname(surname);
        setPermission(permission);
    }
    public  User(String nope){
        String bu = "-brak-użytkownika-"+nope+"-";
        setId(0L);
        setPermission(bu);
        setSurname(bu);
        setName(bu);
        setEmail(bu);
        setPassword(bu);
        setLogin(bu);
    }
}
