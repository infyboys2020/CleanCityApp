<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<meta http-equiv="Content-type" content="text/html;charset=UTF-8">

<title>Clean City Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="https://js.api.here.com/v3/3.1/mapsjs-ui.css" />
<script type="text/javascript" src='/js/test-credentials.js'></script>
<script type="text/javascript"
	src="https://js.api.here.com/v3/3.1/mapsjs-core.js"></script>
<script type="text/javascript"
	src="https://js.api.here.com/v3/3.1/mapsjs-service.js"></script>
<script type="text/javascript"
	src="https://js.api.here.com/v3/3.1/mapsjs-ui.js"></script>
<script type="text/javascript"
	src="https://js.api.here.com/v3/3.1/mapsjs-mapevents.js"></script>
<script src="https://cdn.anychart.com/js/8.0.1/anychart-core.min.js"></script>
<script src="https://cdn.anychart.com/js/8.0.1/anychart-pie.min.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/CleanCityDesign.css">
<script src="/js/reportPopulatorScript.js"></script>


<style type="text/css">
#containertype, #containerpin {
	width: 90%;
	height: 350px;
	margin: 0;
	padding: 0;
}

#map {
	/* width: 50%;
    	float:right; */
	height: 350px;
	background: grey;
}
li{
	width: 40%;
    text-align: center;
    color: white;
}
a{
    color: white;
    font-weight: 400;
}
</style>
</head>
<body id="markers-on-the-map">
	<div id="titleText">Clean City Records Dashboard</div>
	<div class="login-page" id="login_form" style="display: block">
		<div class="form">
			<form class="login-form">
				<div id="pincode-element" class="wrap-elements">
					<label id="pincode-label" for="pin" class="label-element">Pincode:</label>
					<input type="text" id="pin" />
				</div>
				<div class="wrap-elements">
					<label for="start_date" class="label-element">Start Date:</label> <input
						type="date" id="start_date" name="date">
				</div>
				<div class="wrap-elements">
					<label for="end_date" class="label-element">End Date:</label> <input
						type="date" id="end_date" name="date">
				</div>
				<button type='button' onclick="submitForm()">Search</button>
			</form>
		</div>
	</div>
	<div id="errorMessage"></div>
	</div>

	<div id="report_page" style="display: none">
		<button type='button' onclick="backtoForm()" class="btn-primary" style="margin-left: 20px;">
					Back</button>
		<div id="mapmessage" hidden="hidden"></div>

		<ul id="myTab" class="nav nav-pills">
		<li class="nav-item"><a href="#" class="nav-link active" id="graphlink">Report
					graph</a></li>
			<li class="nav-item"><a href="#" class="nav-link"
				id="maplink">Report map</a></li>
		</ul>

		<div id="reportgraph">
			<div id="containertype"></div>
			<div id="containerpin"></div>
		</div>
		
		<div id="reportmap" style="width: 80%;"  hidden="hidden">
			<div id="map"></div>
		</div>

	</div>
<script type="text/javascript" src="/js/reportMapLoader.js"></script>
</body>
</html>
