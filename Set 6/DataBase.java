import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DataBase {
    
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection student_connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","12345");
            Connection results_connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","12345");
            
            Statement student_statement = student_connection.createStatement();
            Statement results_statement = results_connection.createStatement();
            
            /* First Query */
            ResultSet student_resultSet = student_statement.executeQuery("select count(*) from info");
            if(!student_resultSet.next()){
                System.out.println("No Data Found.");
            }
            else{
                do{
                    System.out.println("1: The total number of students : "+student_resultSet.getString(1));
                            
                }while(student_resultSet.next());
            }
            
            /* Third Query */
            ResultSet results_resultSet = results_statement.executeQuery("select roll from marks where total=(select max(total) from marks);");
            if(!results_resultSet.next()){
                System.out.println("No Data Found.");
            }
            else{
                do{
                    student_resultSet = student_statement.executeQuery("select name from info where roll="+results_resultSet.getInt("roll"));
                    if(!student_resultSet.next()){
                        System.out.println("No record found.");    
                    }
                    else{
                        System.out.println("2: The name of topper student : "+student_resultSet.getString("name"));
                    }
                }while(results_resultSet.next());
            }
            
            /* Last Query */
            results_resultSet = results_statement.executeQuery("select roll from marks where total=(select max(total) from marks where total<(select max(total) from marks));");
            if(!results_resultSet.next()){
                System.out.println("No Data Found.");
            }
            else{
                do{
                    student_resultSet = student_statement.executeQuery("select name from info where roll="+results_resultSet.getInt("roll"));
                    student_resultSet.next();
                    System.out.println("2: The name of Second topper student : "+student_resultSet.getString("name"));
                   }while(results_resultSet.next());                      
            }
            
            student_resultSet.close();
            student_statement.close();
            student_connection.close();
            results_resultSet.close();
            results_statement.close();
            results_connection.close();
        }catch(ClassNotFoundException exception){
            System.out.println(exception.getMessage() + " is a ClassNotFoundException");
        }catch(SQLException exception){
            System.out.println(exception.getMessage()+" is a SQLException");
        }
       
        
    }
}
