package jeaQueue;

import com.group.registration.model.entity.Course;
import com.group.registration.model.entity.Student;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.zip.CheckedOutputStream;

public class DataBaseConnectionPool {
    private JeaQueue<ConnectionWrapper> connections;
    PreparedStatement preparedStatement;
    public  DataBaseConnectionPool(){
        this.connections=new JeaQueue<ConnectionWrapper>(10);

    }
    public ConnectionWrapper getConnection() throws SQLException {
        if (this.connections.isEmpty()) {
            System.out.println("There is No Connection ");
       ConnectionWrapper connectionWrapper   = new ConnectionWrapper(DriverManager.getConnection("jdbc:mysql://localhost/registration", "root", "root@JEA"));
       return connectionWrapper;
        }else {
            ConnectionWrapper connectionWrapper=this.connections.deQueue();
            if (connectionWrapper.isAlive()){
                System.out.println("Connection is Alive ");
                return connectionWrapper;

            }else {
                System.out.println("Connection is Not Alive ");
                connectionWrapper.getConnection().close();
                return getConnection();
            }
        }
    }
    public void releaseConnection(ConnectionWrapper connectionWrapper){
        this.connections.enQueue(connectionWrapper);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query);
        ResultSet studentInformation = preparedStatement.executeQuery();
        return studentInformation;
    }
    //save
    public void executeSave(String query, Student student) throws SQLException {
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,String.valueOf(student.getId()));
        preparedStatement.setString(2,student.getFirstName());
        preparedStatement.setString(3,student.getLastName());
        preparedStatement.setString(4,student.getEmail());
        preparedStatement.setString(5,student.getPassword());
        preparedStatement.setString(6,student.getJoinYear());
        System.out.println("execute is ready");
        preparedStatement.executeUpdate();
        System.out.println("Saving process Done !");
    }
    //update
    public void executeUp(String query,Student student) throws SQLException {
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,student.getEmail());
        preparedStatement.setString(2,student.getPassword());
        preparedStatement.executeUpdate();
        System.out.println("Updated Successfully ");
    }

    public void executeSaveCourse(String query, Course course) throws SQLException {
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,String.valueOf(course.getId()));
        preparedStatement.setString(2,course.getName());
        preparedStatement.setString(3,course.getCode());
        preparedStatement.setString(4,course.getCapacity().toString());
        System.out.println("execute is ready");
        preparedStatement.executeUpdate();
        System.out.println("Saving process Done !");
    }
}
