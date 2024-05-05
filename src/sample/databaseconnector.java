package sample;

import java.sql.*;

public class databaseconnector {

    private Connection databaselink;

    public Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/cab?characterEncoding=latin1";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, "root", "ashar2001");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaselink;
    }
}


//    public void updateTask(Timestamp datecreated, String description, String task, int taskId) throws SQLException, ClassNotFoundException {
//
//        String query = "UPDATE tasks SET datecreated=?, description=?, task=? WHERE taskid=?";
//
//
//        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
//        preparedStatement.setTimestamp(1, datecreated);
//        preparedStatement.setString(2, description);
//        preparedStatement.setString(3, task);
//        // preparedStatement.setInt(4, userId);
//        preparedStatement.setInt(4, taskId);
//        preparedStatement.executeUpdate();
//        preparedStatement.close();
//
//    }

    //Delete Task
//    public void deleteTask(int userId, int taskId) throws SQLException, ClassNotFoundException {
//        String query = "DELETE FROM " + Const.TASKS_TABLE + " WHERE "+
//                Const.USERS_ID + "=?" + " AND " + Const.TASKS_ID + "=?";
//
//        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
//        preparedStatement.setInt(1, userId);
//        preparedStatement.setInt(2, taskId);
//        preparedStatement.execute();
//        preparedStatement.close();
//    }
    //Write


