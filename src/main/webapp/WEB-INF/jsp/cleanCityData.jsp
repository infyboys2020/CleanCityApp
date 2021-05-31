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
<script src="/js/cleanCityData.js"></script>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/CleanCityDesign.css">
<script>
var data= eval('('+'${dataFetched}'+')');
</script>
</head>
<body id="markers-on-the-map">
<div id="titleText">Clean City Records</div>
<div id="orderModal" class="modal fade" role="dialog" 
     aria-labelledby="orderModalLabel" aria-hidden="true">
  <div class="modal-dialog">   
 	<div class="modal-header">
      <h3 style="font-weight: bolder;">Incident Details</h3>
  </div>
  <div id="orderDetails"class="modal-body"></div>
    <div class="modal-footer">
    <div id="success-shown" class="success-div">
    	<p class="success-message">
    		You have successfully changed the status of the incident. Please close the popup and refresh the page to se updated status.
    	</p>
    </div>
    <button class="btn btn-success detail-close" id="detail_action" aria-hidden="true" value="Action"></button>
    <button class="btn btn-success detail-close" data-dismiss="modal" aria-hidden="true">Close</button>
  </div>
  </div> 
 </div>
<div class="data-page">
  <div class="form" style="max-width: max-content;">
	<table id="data-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>NAME</th>
          <th>ADDRESS</th>
          <th>TYPE</th>
          <th>PHONE NUMBER</th>
          <th>DATE</th>
          <th>STATUS</th>
        </tr>
      <thead>
      <tbody>       
      </tbody>
    <table/>
  </div>
</div>

</body>
</html>
