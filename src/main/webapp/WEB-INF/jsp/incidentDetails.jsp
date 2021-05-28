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
<script src="/js/cleanCityInfo.js"></script>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/CleanCityDesign.css">
<script>
	var id="${id}";
	var name="${name}";
	var address="${address}";
	var phone="${phone}";
	var pin="${pin}";
	var latitude="${latitude}";
	var longitude="${longitude}";
	var status="${status}";
	var type="${type}";
	var ComplaintSubmissionDate="${ComplaintSubmissionDate}";
	var photo="data:image/png;base64, "+"${photo}";
			

</script>
</head>
<body id="markers-on-the-map">
<div>
<h3 class="details-heading">Details of incident</h3>
<p id="incident-id" class="details-inci"></p>
<p id="name-of-reporter" class="details-inci"></p>
<p id="address-of-reporter" class="details-inci"></p>
<p id="contact-of-reporter" class="details-inci"></p>
<p id="address-pin" class="details-inci"></p>
<p id="type-of-incident" class="details-inci"></p>
<p id="report-status" class="details-inci"></p>
<p id="reporting-date" class="details-inci"></p>
</div>
<div id="image-holder">
<h3 class="details-heading">Images of incident</h3>
<img id="image-holder-place" style="width: 60%;" alt="Red dot" />
</div>
</body>
</html>
