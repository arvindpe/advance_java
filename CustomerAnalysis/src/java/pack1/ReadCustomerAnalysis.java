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
public class ReadCustomerAnalysis extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        String URL="jdbc:derby://localhost:1527/RegisterPage";
        double tpurchase=0;
        double tprise;
        double sum=0;
        try
        {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con=DriverManager.getConnection(URL,"database","arvind");
        
            java.sql.Statement stmt =con.createStatement();
        
        String qry="Select id,productid,productprice,totalprice,purchasedate,type,discount  from APP.customer";
      
            java.sql.ResultSet rs=stmt.executeQuery(qry);
        while(rs.next())     
        {
          int cusid=rs.getInt("id");
          int pid=rs.getInt("productid");
          int date=Integer.parseInt(rs.getString("purchasedate"));
          double discount=rs.getInt("discount");
          tprise=rs.getDouble("totalprice");
          String type=rs.getString("type");
         
          {
            out.println("<br/>purchase made by cus id"+cusid+"="+tprise);  
          }
          
          if(discount>=25)
          {
          out.print("<br> following product ID have discount greater than 25%");
          out.println("<br>"+pid);
          }
           
          if(date>01012017 && date<31012017)
          {
          sum+=tprise;
          }
          
          if("automobile".equals(type))
          {
              sum+=tprise;
              out.println("<br/>automobile has cell"+sum);
          }
           if("medicine".equals(type))
          {
              sum+=tprise;
              out.println("<br/>medicine has cell"+sum);
          }
            if("electronic".equals(type))
          {
              sum+=tprise;
              out.println("<br/>electronic has cell"+sum);
          }
        }
        out.println("<br/>total purchaase in between 01 jan to 31 jan is:"+sum);
        }
        
        catch(Exception e)
        {
        out.println(e);
        
        }
        }
}
    

