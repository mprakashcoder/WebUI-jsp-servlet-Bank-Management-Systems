
<!DOCTYPE html>
<html>
<head>
    <title>Customer Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
  <h1>Bank Management Systems</h1>

  <p>To Provide Customer Services...</p>
</div>
  <div class="container">

 <a href="http://localhost:8080/BankManagementSystems/card.jsp" button type="button" class="btn btn-info">card form</a></button>

<a href="http://localhost:8080/BankManagementSystems/cardRetrieveServlet" button type="button" class="btn btn-primary">Display Card Info</a></button>

<a href="http://localhost:8080/BankManagementSystems/customer.jsp" button type="button" class="btn btn-info">Customer form</a></button>

<a href="http://localhost:8080/BankManagementSystems/customerRetrieveServlet" button type="button" class="btn btn-primary">Display Customer Info</button>

<a href="http://localhost:8080/BankManagementSystems/account.jsp" button type="button" class="btn btn-info">Account form</a></button>


<a href="http://localhost:8080/BankManagementSystems/accountRetrieveServlet"button type="button" class="btn btn-primary">Display Account Info</a></button>


<a href="http://localhost:8080/BankManagementSystems/depositMoney.jsp" button type="button" class="btn btn-info">Deposit Money</a></button>

<a href="http://localhost:8080/BankManagementSystems/withdrawMoney.jsp" button type="button" class="btn btn-info">Withdraw Money</a></button>
<hr>
<a href="http://localhost:8080/BankManagementSystems/checkBalance.jsp" button type="button" class="btn btn-success">Check Balance</a></button>
    <div class="row">

        <div class="form-container">
            <h2>Customer Form</h2>
            <form action="/BankManagementSystems/customer" method="POST">
               <div class="form-group">
                    <label for="customerId">CustomerId:</label>
                    <input type="text" class="form-control" id="customerId" name="customerId" placeholder="Enter customerId" required>
                </div>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required>
                </div>

                <div class="form-group">
                    <label for="mobileNo">MobileNo:</label>
                    <input type="text" class="form-control" id="mobileNo" name="mobileNo" placeholder="Enter Mobile No" required>
                </div>

                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Enter address" required>
                </div>
                <div class="form-group">
                    <label for="emailId">EmailId:</label>
                    <input type="text" class="form-control" id="emailId" name="emailId" placeholder=" Enter Account EmailId" required>
                </div>
                <div class="form-group">
                    <label for="aadhaarNo">aadhaarNo:</label>
                    <input type="text" class="cvv" id="aadhaarNo" name="aadhaarNo" placeholder=" Enter AadhaarNo" required>
                </div>
                <input type="submit"  value="Submit">
            </form>
        </div>

</body>
</html>
