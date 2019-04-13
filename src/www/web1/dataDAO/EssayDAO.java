package www.web1.dataDAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import www.web1.javaBean.Eassy;

public class EssayDAO {
	  
    public EssayDAO() {
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
  
            String sql = "select count(*) from eassy";
  
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
  
    public void add(Eassy eassy) {
  
        String sql = "insert into eassy values(?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, eassy.getID());
            ps.setString(2, eassy.getHeadline());
            ps.setString(3, eassy.getType());
            ps.setString(4, eassy.getContent());
            ps.setInt(5, eassy.getSkim());
            ps.setInt(6, eassy.getThump());
            System.out.println(ps.execute());
            ps.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        System.out.println("上传");
    }
  
    public void update(Eassy eassy) {
  
        String sql = "update eassy set type=? content=? where ID=? and headline=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        ps.setString(1, eassy.getType());
        ps.setString(2, eassy.getContent());
        ps.setString(3, eassy.getID());
        ps.setString(4, eassy.getHeadline());

        ps.execute();
        ps.close();
        c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(String id,String headline) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from eassy where ID = '" + id+"'and headline='"+ headline+"'";
  
            s.execute(sql);
            s.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
    public Eassy get(String id, String headline) {
        Eassy eassy = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from eassy where ID = '" + id +"' and headline='"+headline+"'";
  
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
            	eassy = new Eassy(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
            }
            rs.close();
            s.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return eassy;
    }
   
   public List<Eassy> list(int start, int end, String id){
	   List<Eassy> eassys = new ArrayList<Eassy>();
	   Eassy eassy = new Eassy();
	   
       String sql = "select * from eassy where ID='"+id+"' order by ID desc limit ?,? ";
 
       try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
           ps.setInt(1, start);
           ps.setInt(2, end);
 
           ResultSet rs = ps.executeQuery();
 
           while (rs.next()) {
        	   eassy = new Eassy(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));  
        	   eassys.add(eassy);
           }
       } catch (SQLException e) {
    	   
           e.printStackTrace();
       }
       System.out.println("长度为："+eassys.size());
       return eassys;
   }
   public List<Eassy> list2(int start, int end){
	   List<Eassy> eassys = new ArrayList<Eassy>();
	   Eassy eassy = new Eassy();
	   
       String sql = "select * from eassy order by ID desc limit ?,? ";
 
       try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
           ps.setInt(1, start);
           ps.setInt(2, end);
 
           ResultSet rs = ps.executeQuery();
 
           while (rs.next()) {
        	   eassy = new Eassy(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));  
        	   eassys.add(eassy);
           }
       } catch (SQLException e) {
    	   
           e.printStackTrace();
       }
       System.out.println("长度为："+eassys.size());
       return eassys;
   }
   public List<Eassy> list(String id){
	   return list(0, Integer.MAX_VALUE, id);
   }
}
