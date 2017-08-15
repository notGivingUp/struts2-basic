
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
</head>
<body>
<h1>Struts 2 + Hibernate integration example</h1>
<s:form action="addEmployee" >
  <s:textfield name="employee.firstName" label="First Name" value="" />
  <s:textfield name="employee.lastName" label="Last Name" value="" />
  <s:textfield name="employee.salary" label="Salary" value="" />
  <s:submit />
</s:form>
<a href="listEmployeeAction">List User</a>
</body>
</html>