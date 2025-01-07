<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="regform" method="post"> 
          Name : <input type = "text" name= "name1"><br><br>
           Email : <input type = "text" name= "email1"><br><br>
            password : <input type = "password" name= "ps1"><br><br>
             Gender : <input type = "radio" name= "gender1" value="male"> male
             <input type = "radio" name="gender1" value = "female">female<br><br>
             
             City : <select name="city1">
             <option> select city</option> <br><br>
             <option> delhi </option> <br><br>
             <option> indore </option> <br><br>
             <option> mumbai </option> <br><br>
             <option> goa </option>    <br><br>                      
             </select> <br><br>
             <input type="submit" value="Register"/>
</form>
</body>
</html>