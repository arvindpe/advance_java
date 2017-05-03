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
public class ReadEmployee extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        String URL="jdbc:derby://localhost:1527/RegisterPage";
        int ecount=0; int scount=0;  int rcount=0;
        int count1=0;
        int devcount=0;
        int design=0;
        double avgsal=0;
        int pune=0; int mumbai=0; double designavg=0; double testingavg=0; double devavg=0; 
        try
        {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con=DriverManager.getConnection(URL,"database","arvind");
        
            java.sql.Statement stmt =con.createStatement();
        
        String qry="Select id,name,age,address,salary,jdate,department,dob,status  from APP.Employee";
      
            java.sql.ResultSet rs=stmt.executeQuery(qry);
        while(rs.next())     
        {
            
        int id=rs.getInt("id");
        String dept=rs.getString("department");
        String city=rs.getString("address");
        int sal=rs.getInt("salary");
        String status=rs.getString("status");
        int age=rs.getInt("age");
       
       if(id!=0)
        {
       
        ecount=ecount+1;
        }
       if("testing".equals(dept))
       {
       count1=count1+1;
        double testingsal=sal+sal;
           testingavg= testingsal/count1;
       }
        if("developing".equals(dept))
       {
           devcount=devcount+1;
      
          double devsal=sal+sal;
          devavg= devsal/devcount;
           
       }
       if("design".equals(dept))
       {
           design++;
          double designsal=sal+sal;
           designavg= designsal/design;
           design=0;
           
       }
       
       if("pune".equals(city))
       {pune++;}
       
       
       if("mumbai".equals(city))
       {mumbai++;}
       
       double total=sal+sal;
       avgsal=total/ecount;
       
       if("single".equals(status))
       {
       
       scount=scount+1;
       
       }
       
       if(age==58)
       {
       rcount=rcount+1;
       }
       
       
        }
        out.println("Total number of employee are="+ecount);
        out.println("<br/>Total number of employee in testing department are="+count1);
        out.println("<br>Total number of employee in develper department are="+devcount);
        out.println("<br>Total number of employee design department  are="+design);
         out.println("<br>Total number of employee in pune are="+pune);
          out.println("<br>Total number of employee in mumbai are="+mumbai);
          out.println("<br>Total avg salary in design dept is="+designavg);
          out.println("<br>Total avg salary in devlopment dept is="+devavg);
          out.println("<br>Total avg salary in testing dept is="+testingavg);
          out.println("<br/> average salary:"+avgsal);
          out.println("<br/> Total employee having single status:"+scount);
           out.println("<br/> Total employee retired in next 2 year:"+rcount);
        
        
        }     
        catch(Exception e)
        {
        out.println(e);
        }
    }
}
