$(document).ready(function() {
		$("#search-data").click(function(){
			$(".login-page").hide();
			submitForm();
		});
});

function submitForm(){
	$.ajax({
		url:"/fetch/data",
		data:"pin="+document.getElementById("pincode_value").value + "&start_date=" + document.getElementById("start-date").value
					+ "&end_date=" + document.getElementById("end-date").value,
		async : false,
		type:'get',
	  	success:function(json){
			$("#errorMessage").text('');
			populateTable(json);
	  	},
		error:function(error){
			map.removeObjects(map.getObjects());
			$("#errorMessage").text(error.responseText);
		}
	});
}

function populateTable(message){
	var parsedJSON = JSON.parse(message);
	shareInfoLen = Object.keys(parsedJSON).length;
	var table = document.getElementById("data-table");
	var row="";
	for(var i=0;i<shareInfoLen;i++){
		var markup = "<tr><td>" + parsedJSON[i].id + "</td><td>" + parsedJSON[i].name + "</td><td>" + parsedJSON[i].address + "</td><td>" + parsedJSON[i].type + "</td><td>" + parsedJSON[i].phone_number + "</td><td>" + parsedJSON[i].complaintSubmissionDate + "</td><td>" + parsedJSON[i].status + "</td></tr>";
        $("table tbody").append(markup);
		
	}
	$(".data-page").show();
}