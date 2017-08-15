<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function doDownload(id, x) {
	
	document.forms[0].id.value = id;
	document.forms[0].event.value = x;
	//alert(document.forms[0].event.value);
	//alert(document.forms[0].id.value);
	document.forms[0].submit();
}

</script>
</head>
<body>
	<h2>All Employee</h2>

	<s:if test="employeeList.size() > 0">
	<s:form action="eventAction">
			<table border="1px" cellpadding="8px">
				<tr>
					<th>Id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Salary</th>
					<th>Option</th>
				</tr>
				<s:iterator value="employeeList" status="employeeStatus">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="firstName" /></td>
						<td><s:property value="lastName" /></td>
						<td><s:property value="salary" /></td>
						<td>
							<s:a href="#" onclick="doDownload(%{id},'edit')" >edit</s:a>
							<s:a href="#" onclick="doDownload(%{id},'delete')" >delete</s:a>
						</td>
					</tr>
				</s:iterator>
			</table>
			<s:hidden name="id" value="" />
			<s:hidden name="event" value="" />
		</s:form>
	</s:if>
	<br />
	<br />
</body>
</html>