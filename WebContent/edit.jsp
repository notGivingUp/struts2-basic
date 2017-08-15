<%@page import="model.Employee"%>	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Update</h3>
<%Employee selectedEmployee=(Employee) request.getAttribute("selectedEmployee"); %>

<form action="edit" method="post">
 ID: <input type="text" name="employee.id" value="<%=selectedEmployee.getId() %>">
<br/>First name: <input type="text" name="employee.firstName" value="<%=selectedEmployee.getFirstName() %>">
<br/>Last name: <input type="text" name="employee.lastName" value="<%=selectedEmployee.getLastName() %>">
<br/>Salary: <input type="text" name="employee.salary" value="<%=selectedEmployee.getSalary() %>"><br/>

<input type="submit" value="update">
<!-- <p style="color:red"> dung textfield se bi loi </p> -->
</form>
</body>
</html>