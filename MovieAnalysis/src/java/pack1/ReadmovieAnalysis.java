/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rohit Ra
 */
public class ReadmovieAnalysis extends HttpServlet 
{
public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        String URL="jdbc:derby://localhost:1527/RegisterPage";
        String name="";
        try
        {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con=DriverManager.getConnection(URL,"database","arvind");
        
            java.sql.Statement stmt =con.createStatement();
        
        String qry="Select name,type,director,rdate  from APP.MOVIE";
      
            java.sql.ResultSet rs=stmt.executeQuery(qry);
            
        while(rs.next())     
        {
            
         name=rs.getString("name");
        String category=rs.getString("type");
         String date=rs.getString("rdate");
         String director=rs.getString("director");
         
         if((date.substring(3,4)).equals("01"))
   
       {
           out.println("</br>Movies released in between 1 jan to 31 jan are:");
            out.println(name);
        }
       
       if("U".equals(category))
       {
          out.println("<br/>Movies belongs to U category are:");
       out.println(name);
       
       }
       
       if("XYZ".equals(director))
       {
       out.println("<br/>movies directed by director XYZ are:");
       out.println(name);
       
       
       }
       }
        
    
       
        
        }     
        catch(Exception e)
        {
        out.println(e);
        }
    }

    private String toString(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
