<%@ taglib uri="jakarta.tags.core" prefix="c"  %>

<!DOCTYPE html>
<html>

<head>
  
  <title>List Customers</title>
</head>

<body>
  <div id="wrapper">
    <div id="header">
      <h2>CRM - Custoemr Relationship Manager</h2>
    </div>
  </div>

  <a href="/customer/showForm">Add Customer</a>

  <div id="container">
    <div id="content"> 
      <table>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>More</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
          <c:url var="updateLink" value="/customer/showFormForUpdate">
            <c:param name="customerId" value="${customer.id}"/>
          </c:url>

          <c:url var="deleteLink" value="/customer/deleteCustomer">
            <c:param name="customerId" value="${customer.id}"/>
          </c:url>
          <tr>
            <td> ${customer.firstName}</td>
            <td> ${customer.lastName}</td>
            <td> ${customer.email}</td>
            <td><a href="${updateLink}">Update</a>|<a href="${deleteLink}">Delete</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</body>

</html>