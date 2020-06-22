<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<title>List Customers</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
	
	</head>
	
	
	<body>
		
		<div id="wrapper">
			<div id="header">
				<h2>
					CRM-Customer Relationship Manager
				</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
			<input type="button" value="AddCustomer" onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
			/>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customer}">
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerID" value="${tempCustomer.id}"/>
						</c:url>
						<c:url var="deleteLink" value="/customer/showFormForDelete">
							<c:param name="customerID" value="${tempCustomer.id}"/>
						</c:url>
						<tr>
							<td> ${tempCustomer.firstName}</td>
							<td> ${tempCustomer.lastName}</td>
							<td> ${tempCustomer.email}</td>
							<td>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}" 
								onclick="if (!(confirm('Are you sure you want to delete this customer?')))return false">Delete</a>
							</td>
					
						</tr>
						
					</c:forEach>
				</table>
							
				
			</div>				
		</div>
	
	</body>

</html>