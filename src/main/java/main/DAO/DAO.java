package main.DAO;

import javafx.collections.ObservableList;
import main.models.Event;
import main.models.FoodType;
import main.models.User;
import main.models.UserOnEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface DAO {
    Connection MySqlConnection();

    boolean addUser(User user);
    boolean modifyUser(Long userId, User newUserData);
    boolean deleteUser(Long userId);
    User getUser(Long UserId);
    boolean resetPassword(Long userId,String newPassword);


    boolean addEvent(Event event);
    boolean modifyEvent(Long eventId, Event newEventData);
    boolean deleteEvent(Long eventId);
    Event getEvent(Long eventId);

    boolean addUserOnEvent(UserOnEvent userOnEvent);
    boolean modifyUserOnEvent(Long uoeId);
    boolean deleteUserOnEvent(Long uoeId);
    UserOnEvent getUserOnEvent(Long uoeId);
    boolean accept(Long uoeId);
    boolean discard(Long uoeId);

    ObservableList<Event> findAllEvents();
    ObservableList<FoodType> findAllFoodTypes();
    ObservableList<User> findAllUsers();
    ObservableList<UserOnEvent> findAllUsersUserOnEvents();
}
