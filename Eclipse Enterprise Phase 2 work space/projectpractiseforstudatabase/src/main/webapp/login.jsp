<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="shortcut icon" href="favicon.ico" />
  <meta charset="UTF-8">

  <title>Login </title>

  <link rel="stylesheet" href="css/reset.css">

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

</head>

<body>
</br></br></br></br>


<h1 align="center" style="background-color:black;color:red;font-family:Times New Roman; font-size: 300%;"> Welcome to Learner's Academy Administrative Portal!</h2>
	
	
  <div class="wrap">
  <h2 align="center" style="background-color:lightgreen;border-radius: 30px;color:black;font-size:200%">Administrator Login</h2>
  <form action="dashboard" method="post">
		<div class="avatar">
      <img src="user img.png">
		</div>
		<input type="text" name="username" placeholder="username" required>
		<div class="bar">
			<i></i>
		</div>
		<input type="password" name="password" placeholder="password" required>
		<a href="" class="forgot_link">forgot ?</a>
		<button type="submit">Sign in</button>
		</form>
	</div>

  <script src="js/login.js"></script>

</body>
</html>