<%@ taglib uri="jakarta.tags.core" prefix="c"  %>

<!DOCTYPE html>
<html>

<head>
  
  <title>Add Customer</title>
</head>

<body>
  <div id="container">
    <h2>Add Customer</h2>
    <form action="/customer/addCustomer" method="post">
        First Name : <input type="text" name ="firstName"/>
        <br><br>
        Last Name:  <input type="text" name ="lastName"/>
        <br><br>
        Email:  <input type="text" name ="email"/>
        <br><br>
        <input type="submit" value ="add"/>
    </form>
  </div>
</body>

</html>