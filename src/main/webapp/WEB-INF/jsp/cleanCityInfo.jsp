<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<meta http-equiv="Content-type" content="text/html;charset=UTF-8">

<title>Clean City</title>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/CleanCityDesign.css">
</head>
<body id="markers-on-the-map">
<div id="titleText">Clean City Records</div>
<div class="login-page" style="display:block">
  <div class="form">
    <form class="login-form">
	<div id="pincode-element" class="wrap-elements">
		<label id="pincode-label" for="pincode_value" class="label-element">Pincode:</label>
      <input type="text" id="pincode_value" />
	  </div>
	  <div class="wrap-elements">
	  <label for="start-date" class="label-element">Start Date:</label>
	  <input type = "date" id="start-date" name = "date">
	  </div>
	  <div class="wrap-elements">
	  <label for="end-date" class="label-element">End Date:</label>
	  <input type = "date" id="end-date" name = "date">
	  </div>
      <button>Search</button>
    </form>
	</div>
	</div>
	<div class="data-page" style="display:none">
  <div class="form">
	<form class="data-form">
      <table id="data-table">
      <thead>
        <tr>
          <th>CODE</th>
          <th>STOCK</th>
          <th>CAP</th>
          <th>INCH</th>
          <th>BOX TYPE</th>
        </tr>
      <thead>
      <tbody>
        <tr>
          <td>CES-9000</td>
          <td>50mt</td>
          <td>9mm</td>
          <td>1/2"</td>
          <td>Kangal / Coil</td>
        </tr>
           <tr>
          <td>CES-9000</td>
          <td>50mt</td>
          <td>9mm</td>
          <td>1/2"</td>
          <td>Kangal / Coil</td>
        </tr>
           <tr>
          <td>CES-9000</td>
          <td>50mt</td>
          <td>9mm</td>
          <td>1/2"</td>
          <td>Kangal / Coil</td>
        </tr>
           <tr>
          <td>CES-9000</td>
          <td>50mt</td>
          <td>9mm</td>
          <td>1/2"</td>
          <td>Kangal / Coil</td>
        </tr>
      </tbody>
    <table/>
    </form>
  </div>
</div>

</body>
</html>
