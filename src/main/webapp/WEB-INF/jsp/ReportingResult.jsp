<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
<title>Getting Started: Handling Form Submission</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/bootstrap.min.css">

<body>
	<div class="page-header">
		<h1>Result</h1>
	</div>
	<div class="login-header">
		<h3>${status}</h3>
		<br>
		<h3>Please note this ticket ID for future reference: ${ticketId}
		</h3>
		<a href="/reportBoard">Submit another report</a>
	</div>
</body>
</html>