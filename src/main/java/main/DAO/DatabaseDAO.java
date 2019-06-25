package main.DAO;

import javafx.collections.ObservableList;
import main.models.Event;
import main.models.FoodType;
import main.models.User;
import main.models.UserOnEvent;

import java.sql.*;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DatabaseDAO {
    public Connection MySqlConnection() {
        Connection MySqlConn = null;
        try {
            MySqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psw" +
                          "?useUnicode=true" +
                          "&useJDBCCompliantTimezoneShift=true" +
                          "&useLegacyDatetimeCode=false" +
                          "&serverTimezone=UTC",
                    "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return MySqlConn;
    }

    public boolean addUser(User user) {
        String query = String.format("INSERT INTO"
                        +"users (login,password,email,name,surname,permission)"
                        +" VALUES({0},{1},{2},{3},{4},{5},{6})",
                        user.getLogin(),user.getPassword(),user.getEmail(),user.getName(),user.getSurname(),user.getPermission()
        );
        try {
            return MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean modifyUser(Long userId, User newUserData) {
        String query = String.format("UPDATE users"
                        +"SET login='{0}',password='{1}',email='{2}',name='{3}',surname='{4}',permission='{5}'"
                        +"WHERE id={6};",
                newUserData.getLogin(),//0
                newUserData.getPassword(),//1
                newUserData.getEmail(),//2
                newUserData.getName(),//3
                newUserData.getSurname(),//4
                newUserData.getPermission(),//5
                userId.toString()
                );
        try{
            return  MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean deleteUser(Long userId) {
        String query = String.format("DELETE FROM users"
        +"WHERE id={0};",
                userId.toString()
        );
        try{
            return MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public User getUser(Long userId) {
        String query = String.format("SELECT * FROM users"
                        +"WHERE id={0};",
                userId.toString()
        );
        try{
            ResultSet set = MySqlConnection().prepareStatement(query).executeQuery();
            return new User(set.getLong("id"),
                    set.getString("login"),
                    set.getString("password"),
                    set.getString("email"),
                    set.getString("name"),
                    set.getString("surname"),
                    set.getString("permission")
            );
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return new User("getUser");
    }

    public boolean resetPassword(Long userId, String newPassword) {
        String query = String.format("UPDATE users"
                        +"password='{1}'"
                        +"WHERE id={0};",
                userId.toString(),
                newPassword
        );
        try{
            return  MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean addEvent(Event event) {
        String query = String.format("INSERT INTO"
                        +"events (name,agenda,date,organizer)"
                        +"VALUES({0},{1},{2},{3},{4})",
                event.getName(),
                event.getAgenda(),
                event.getDate().toString(),
                event.getOrganizer().getId()
        );
        try {
            return MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean modifyEvent(Long eventId, Event newEventData) {
        String query = String.format("UPDATE events"
                        +"SET name='{1}',agenda='{2}',date='{3}',organizer='{4}'"
                        +"WHERE id={0};",
                eventId.toString(),
                newEventData.getName(),
                newEventData.getAgenda(),
                newEventData.getDate(),
                newEventData.getOrganizer().getId()
        );
        try{
            return  MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean deleteEvent(Long eventId) {
        String query = String.format("DELETE FROM events"
                        +"WHERE id={0};",
                eventId.toString()
        );
        try{
            return MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public Event getEvent(Long eventId) {
        String query = String.format("SELECT * FROM events"
                        +"WHERE id={0};",
                eventId.toString()
        );
        try{
            ResultSet set = MySqlConnection().prepareStatement(query).executeQuery();
            Event event = new Event();
            event.setOrganizer(getUser(set.getLong("org")));
            event.setDate(set.getDate("date"));
            event.setAgenda(set.getString("agenda"));
            event.setName(set.getString("name"));
            event.setId(set.getLong("id"));
            return event;

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        String bw = "-BRAK WYDARZENIA-";
        Event event = new Event();
        event.setId(0L);
        event.setName(bw);
        event.setAgenda(bw);
        event.setDate(new Date());
        event.setOrganizer(getUser(0L));
        return event;
    }

    public boolean addUserOnEvent(UserOnEvent userOnEvent) {
        String query = String.format("INSERT INTO"
                        +"uoe (event,user,foodType,confirmed)"
                        +"VALUES({0},{1},{2},{3})",
                userOnEvent.getEvent().getId(),
                userOnEvent.getUser().getId(),
                userOnEvent.getFoodType().getId(),
                "false"
        );
        try {
            return MySqlConnection().prepareStatement(query).execute();

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean modifyUserOnEvent(Long uoeId, UserOnEvent newUoeData) {
        String query = String.format("UPDATE ueo"
                        +"SET event='{1}',user='{2}',foodType='{3}',confirmed='{4}'"
                        +"WHERE id={0};",
                uoeId,
                newUoeData.getEvent().getId(),
                newUoeData.getUser().getId(),
                newUoeData.getFoodType().getId(),
                newUoeData.getConfirmed().toString()
        );
        try{
            return  MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean deleteUserOnEvent(Long uoeId) {
        String query = String.format("DELETE FROM uoe"
                        +"WHERE id={0};",
                uoeId.toString()
        );
        try{
            return MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public UserOnEvent getUserOnEvent(Long uoeId) {
        String query = String.format("SELECT * FROM uoe"
                        +"WHERE id={0};",
                uoeId.toString()
        );
        try{
            ResultSet set = MySqlConnection().prepareStatement(query).executeQuery();
            UserOnEvent uoe = new UserOnEvent();
            uoe.setUser(getUser(set.getLong("user")));
            uoe.setConfirmed(set.getBoolean("confirmed"));
            uoe.setFoodType(getFoodType(set.getLong("id")));
            uoe.setEvent(getEvent(set.getLong("event")));
            uoe.setId(set.getLong("id"));
            return uoe;

        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        String bw = "-BRAK WYDARZENIA-";
        Event event = new Event();
        event.setId(0L);
        event.setName(bw);
        event.setAgenda(bw);
        event.setDate(new Date());
        event.setOrganizer(getUser(0L));

        UserOnEvent uoe = new UserOnEvent();
        uoe.setId(0L);
        uoe.setEvent(event);
        uoe.setFoodType(new FoodType(""));
        uoe.setConfirmed(false);
        uoe.setUser(new User("getUoe"));
        return uoe;
    }

    public boolean accept(Long uoeId) {
        String query = String.format("UPDATE ueo"
                        +"SET confirmed=true"
                        +"WHERE id={0};",
                uoeId
        );
        try{
            return  MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean discard(Long uoeId) {
        String query = String.format("UPDATE ueo"
                        +"SET confirmed=false"
                        +"WHERE id={0};",
                uoeId
        );
        try{
            return  MySqlConnection().prepareStatement(query).execute();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public ObservableList<Event> findAllEvents() {
        return null;
    }

    public ObservableList<FoodType> findAllFoodTypes() {
        return null;
    }

    public ObservableList<User> findAllUsers() {
        return null;
    }

    public ObservableList<UserOnEvent> findAllUsersUserOnEvents() {
        return null;
    }

    public FoodType getFoodType(Long id){
        String query = String.format("SELECT * FROM ft"
                        +"WHERE id={0};", id);
        try{
            ResultSet set = MySqlConnection().prepareStatement(query).executeQuery();
            FoodType ft = new FoodType(
              set.getLong("id"),
              set.getString("name")
            );
            return ft;

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return new FoodType("");
    }
}
