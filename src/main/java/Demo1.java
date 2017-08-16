import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;
import java.util.Properties;

public class Demo1 {
    private static String url = "jdbc:mysql://192.168.117.135:3306/lesson1";
    // jdbc协议:数据库子协议:主机:端口/连接的数据库   //

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;

        Driver driver = null;
        try {
            driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            //            2.获取数据库连接
            String url = "jdbc:mysql://192.168.117.135:3306/lesson1";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
//            3.获取数据操作的对象
            statement = conn.createStatement();
            //            4.执行SQL语句，DML语句
           String sql1 = "insert into user(age,username,password) values(18,'xiao','local')";
          //  String sql2 = "delete from user where password='local'";
          //  String sql3 = "update user set age=19 where username='jin'";
            statement.execute(sql1);
            String sql4 = "SELECT * from user";
            res = statement.executeQuery(sql4);
            while(res.next()){
                String username=res.getString("username");
                String passwords = res.getString("password");
                int age = res.getInt("age");
                System.out.println(username+"  "+passwords+"  "+age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}