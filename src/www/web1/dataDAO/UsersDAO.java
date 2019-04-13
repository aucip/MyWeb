package www.web1.dataDAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import www.web1.javaBean.User;
 
  
public class UsersDAO{
  
    public UsersDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javaweb", "root",
                "root");
    }
  
    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from users";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
  
            System.out.println("total:" + total);
            rs.close();
            s.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
  
    public void add(User user) {
  
        String sql = "insert into users values(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, user.getID());
            ps.setString(2, user.getNickname());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getAge());
            ps.setString(5, user.getPrfession());
            ps.setString(6, user.getTele());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getHabby());
            ps.setString(9, user.getAutograph());
            ps.setString(10, user.getPathOfBg().getAbsolutePath());
            ps.setString(11, user.getPathOfHead().getAbsolutePath());
            
            
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public void update(User user) {
  
        String sql = "update users set nickName=? password=? age==? prfession==? tele=? email=? habby=? autograph=? pathOfBg=? PathOfHead=?  where ID=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        ps.setString(11, user.getID());
        ps.setString(1, user.getNickname());
        ps.setString(2, user.getPassword());
        ps.setInt(3, user.getAge());
        ps.setString(4, user.getPrfession());
        ps.setString(5, user.getTele());
        ps.setString(6, user.getEmail());
        ps.setString(7, user.getHabby());
        ps.setString(8, user.getAutograph());
        ps.setString(9, user.getPathOfBg().getAbsolutePath());
        ps.setString(10, user.getPathOfHead().getAbsolutePath());
        ps.execute();
        ps.close();
        c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(String id) {
  
    	String sql = "delete from users where ID =? " ;
        try (Connection c = getConnection(); PreparedStatement s = c.prepareStatement(sql);) {
        	s.setString(1, id);
            s.execute(sql);
            s.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
    public User get(String id) {
        User user = null;
  
        String sql = "select * from users where ID = '"+id+"'" ;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
            	File Bg = new File(rs.getString(10));
            	File Head = new File(rs.getString(11));
            	user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9), Bg, Head);
            }
            rs.close();
            s.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        if(user == null)
        	System.out.println("数据库导出失败");
        return user;
    }
   
}