<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>
   <head>
      <title>INSERT Operation</title>
   </head>
   
   <body>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/TEST"
         user = "root"  password = ""/>
         <sql:update dataSource = "${snapshot}" var = "result">
         INSERT INTO Employees VALUES (104, 2, 'Nuha', 'Ali');
      </sql:update>

      </table>
 
   </body>
</html>