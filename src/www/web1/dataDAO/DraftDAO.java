package www.web1.dataDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import www.web1.javaBean.Draft;
import www.web1.javaBean.Eassy;

public class DraftDAO {
	  
    public DraftDAO() {
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
  
            String sql = "select count(*) from draft";
            
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
  
    public void add(Draft draft) {
  
        String sql = "insert into draft values(?,?,null,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, draft.getID());
            ps.setString(2, draft.getHeadline());
            ps.setString(3, draft.getContent());
            
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public void update(Draft draft, String headline) {
  
        String sql = "update draft set headline=? content=? where ID=? and headline=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        ps.setString(1, headline);
        ps.setString(2, draft.getID());
        ps.setString(3, draft.getHeadline());

        ps.execute();
        ps.close();
        c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(String id,String headline) {
  
    	String sql = "delete from draft where ID =? and headline=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
  
            ps.setString(1, id);
            ps.setString(2, headline);
            ps.execute();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
    public Draft get(String id, String headline) {
    	Draft draft = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from draft where ID = '" + id+"'and headline='" +headline+"'";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
            	draft = new Draft(rs.getString(1), rs.getString(2),rs.getString(4));
            }
            rs.close();
            s.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return draft;
    }
   
   public List<Draft> list(int start, int end, String id){
	   List<Draft> drafts = new ArrayList<Draft>();
	   Draft draft = new Draft();
	   
       String sql = "select * from draft where ID='"+id+"'";
       try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
//           ps.setInt(1, start);
//           ps.setInt(2, end);
// 
           ResultSet rs = ps.executeQuery();
 
           while (rs.next()) {
        	   draft = new Draft(rs.getString(1), rs.getString(2),rs.getString(4));  
        	   drafts.add(draft);
           }
       } catch (SQLException e) {
    	   
           e.printStackTrace();
       }
       if(drafts==null){
    	   System.out.println("鑽夌搴撲负绌�");
       }else{
    	   System.out.println("鍙栧嚭鑽夌鎴愬姛");
       }
       return drafts;
   }
   public List<Draft> list(String id){
	   return list(0, Integer.MAX_VALUE, id);
   }
}
