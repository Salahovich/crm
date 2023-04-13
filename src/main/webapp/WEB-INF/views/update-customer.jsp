<%@ taglib uri="jakarta.tags.core" prefix="c"  %>

<!DOCTYPE html>
<html>

<head>
  
  <title>Update Customer</title>
</head>

<body>
  <div id="container">
    <h2>Update Customer</h2>
    <form action="/customer/updateCustomer" method="post">
        First Name : <input type="text" name ="firstName" value="${customer.firstName}"/>
        <br><br>
        Last Name:  <input type="text" name ="lastName" value="${customer.lastName}"/>
        <br><br>
        Email:  <input type="text" name ="email" value="${customer.email}"/>
        <br><br>
                <input type="hidden" name="id" value="${customer.id}"/>
        <input type="submit" value ="Update"/>
    </form>
  </div>
</body>

</html>