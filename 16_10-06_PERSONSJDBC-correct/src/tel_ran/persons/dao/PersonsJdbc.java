package tel_ran.persons.dao;

import tel_ran.databases.jdbc.DatabaseConnection;
import tel_ran.persons.entities.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PersonsJdbc {
    private static final String TABLE_NAME = "persons";
    private Statement statement;

    public PersonsJdbc() throws Exception {
        DatabaseConnection connection= DatabaseConnection.getDatabaseConnection("root","root",null,null);
        statement=connection.getConnection().createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (Id Integer," +
                "name Varchar(254),birthYear Integer,Primary Key(id))";
        statement.executeUpdate(sql);
    }
    public boolean addPerson(Person person){
        String sql = String.format("INSERT INTO %s (id,name,birthYear) Values(%d,'%s',%d)"
                ,TABLE_NAME,person.getId(),person.getName(),person.getBirthYear());
        boolean res = true;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            res=false;
        }
        return res;
    }

    public boolean removePerson(int id){
        boolean res = true;
        String sql = String.format("DELETE FROM %s WHERE id=%d",TABLE_NAME,id);
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            res=false;
        }
        return res;
    }

    public Person getPerson(int id) {
        String sql = String.format("SELECT * FROM %s WHERE id=%d",TABLE_NAME,id);
        Person person=null;
        ResultSet rs= null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.next()){
                person = getOnePerson(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return person;
    }

    private Person getOnePerson(ResultSet rs) throws SQLException {
        String name= rs.getString("name");
        Integer id= rs.getInt("id");
        Integer birthYear= rs.getInt("birthYear");
        return new Person(id,birthYear,name);
    }

    public Iterable<Person> getPersonsByAge(int ageFrom, int ageTo){
        int yearFrom=getYear(ageTo);
        int yearTo=getYear(ageFrom);
        String sql = String.format("SELECT * FROM %s WHERE birthYear between %d and %d",TABLE_NAME,yearFrom,yearTo);
        return getPersons(sql);
    }

    private Iterable<Person> getPersons(String sql) {
        List<Person> res=new ArrayList<>();
        ResultSet rs= null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                res.add(getOnePerson(rs));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (Iterable<Person>) res;
    }

    public Iterable<Person> getPersonsByName(String name) {
        String sql = String.format("SELECT * FROM %s WHERE name='%s'",TABLE_NAME,name);
        return getPersons(sql);
    }

    private int getYear(int age) {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) - age;
    }





}
