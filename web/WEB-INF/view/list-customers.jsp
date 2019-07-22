<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->
    <%--	three variants of adding css files to jsp--%>

    <%--	<spring:url value="/resources/css/style.css" var="styleCss" />--%>
    <%--	<link href="${styleCss}" rel="stylesheet" />--%>

    <%--	<link href="<c:url value="/resourses/css/style.css" />" rel="stylesheet">--%>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resourses/css/style.css"/>
</head>

<body>

<h1>HELLO WORLD</h1>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <%--put new button add customer--%>
        <input type="button" value="Add Customer"
               onclick="window.location.href = 'showFormForAddCustomer'; return false;"
               class="add-button"
        />

        <!--  add our html table here -->
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempCustomer" items="${customers}">

                <!-- update link with customer id -->
                <c:url var="updateLink" value="/customer/showFormForUpdateCustomer">

                    <c:param name="customerId" value="${tempCustomer.id}"/>

                </c:url>

                <!-- update link with customer id -->
                <c:url var="deleteLink" value="/customer/deleteCustomer">

                    <c:param name="customerId" value="${tempCustomer.id}"/>

                </c:url>


                <tr>
                    <td> ${tempCustomer.firstName} </td>
                    <td> ${tempCustomer.lastName} </td>
                    <td> ${tempCustomer.email} </td>
                    <td><a href="${updateLink}">Update</a>|<a href="${deleteLink}" onclick="if (!(confirm('Are you really want to delete this customer?')))return false">Delete</a></td>

                </tr>

            </c:forEach>

        </table>
    </div>
</div>


</body>

</html>









