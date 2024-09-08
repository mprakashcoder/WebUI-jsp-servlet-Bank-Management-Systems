
<!DOCTYPE html>
<html>
<head>
    <title>Account</title>
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
        <h2>Deposit  Form</h2>
        <form action="/BankManagementSystems/deposit" method="post">
            <div class="form-group">

                <label for="accountNumber">Account Number</label>
                <input type="text" class="form-control" id="accountNumber" name="accountNumber" placeholder="Enter Account Number" required>
            </div>


            <div class="form-group">
                <label for="accountHolderName">accountHolderName:</label>
                <input type="text" class="form-control" id="accountHolderName" name="accountHolderName" placeholder="Enter Account Holder Name" required>
            </div>

            <div class="form-group">
                <label for="balance">Deposit Money</label>
                <input type="text" class="balance" id="balance" name="balance" placeholder="Enter initial(Opening)deposit amount" required>
            </div>
            <div class="form-group">
                <label for=" customerId"> CustomerId:</label>
                <input type="text" class=" customerId" id=" customerId" name=" customerId" placeholder="Enter  customerId" required>
            </div>

            <input type="submit" class="btn btn-primary" value="Submit">
        </form>
    </div>

</body>
</html>
