
<!DOCTYPE html>
<html>
<head>
    <title>Card Form</title>
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

  <p>To Provide card Services...</p>
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

    <div class="form-container" >
        <h2>Card Form</h2>
        <form action="/BankManagementSystems/card" method="POST">
            <div class="form-group">
                <label for="cardId">CardId:</label>
                <input type="text" class="form-control" id="cardId" name="cardId" placeholder="Enter Card Id" required>
            </div>
            <div class="form-group">
                <label for="cardNo">CardNo:</label>
                <input type="text" class="form-control" id="cardNo" name="cardNo" placeholder="Enter Card No" required>
            </div>
            <div class="form-group">
                <label for="accountNo">Account No:</label>
                <input type="text" class="form-control" id="accountNo" name="accountNo" placeholder="Enter Account No" required>
            </div>
            <div class="form-group">
                <label for="accountHolderName">Account Holder Name:</label>
                <input type="text" class="form-control" id="accountHolderName" name="accountHolderName" placeholder=" Enter Account Holder Name" required>
            </div>

            <div class="form-group">
                <label for="postal_code">cvv:</label>
                <input type="text" class="cvv" id="postal_code" name="cvv" placeholder=" Enter cvv" required>
            </div>
            <div class="form-group">
                <label for="postal_code">Card Type:</label>
                <select     class="form-select" aria-label="Default select example">
                    <option selected>Select Card </option>
                    <option value="1">Debit</option>
                    <option value="2">Credit</option>

                </select>
            </div>

            <input type="submit"  value="Submit">
        </form>
    </div>

</body>
</html>
