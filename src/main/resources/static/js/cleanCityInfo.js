$(document).ready(function() {
		$("#search-data").click(function(){
			$(".login-page").hide();
			submitForm();
		});
		
		$("#searchButton").click(function(){
			$(".data-page").hide();
			$("table tbody").html("");
			$(".login-page").show();
		});
		
		$('#orderModal').on('show.bs.modal', function (event) {
			  var myVal = $(event.relatedTarget).data('id');
			  displaySpecificIncident(myVal,$(this));
			  //$(this).find(".modal-body").text(myVal);
			});
		
		document.getElementById("image-holder-place").src = photo;
		$("#incident-id").html("Incident Number: "+id);
		$("#name-of-reporter").html("Name of the reporting person: "+name);
		$("#address-of-reporter").html("Address of the incident: "+address);
		$("#contact-of-reporter").html("Contact number: "+phone);
		$("#address-pin").html("Pin number of the area: "+pin);
		$("#report-status").html("Status of the incident: "+status);
		$("#type-of-incident").html("Type of issue: " +type);
		$("#reporting-date").html("Reprting date: "+ComplaintSubmissionDate);
		
		
});

function submitForm(){
	$.ajax({
		url:"/admin/fetch/data",
		data:"pin="+document.getElementById("pincode_value").value + "&start_date=" + document.getElementById("start-date").value
					+ "&end_date=" + document.getElementById("end-date").value,
		async : false,
		type:'get',
	  	success:function(json){
			$("#errorMessage").text('');
			populateTable(json);
	  	},
		error:function(error){
			//map.removeObjects(map.getObjects());
			//$("#errorMessage").text(error.responseText);
			populateTable(error.responseText);
			//$("#errorMessage").text(error.responseJSON.message);
		}
	});
}

function populateTable(message){
	var parsedJSON = JSON.parse(message);
	
	//error scenario
	if(parsedJSON.status==404){
	var errorText ='<tr><td colspan="7" style="text-align:center">No records found</td></tr>';
	$("table tbody").append(errorText);
	}else{
	
	shareInfoLen = Object.keys(parsedJSON).length;
	var table = document.getElementById("data-table");
	var row="";
	for(var i=0;i<shareInfoLen;i++){
		var markup = "<tr data-toggle='modal' data-id="+parsedJSON[i].id+" data-target='#orderModal'><td>" + parsedJSON[i].id + "</td><td>" + parsedJSON[i].name + "</td><td>" + parsedJSON[i].address + "</td><td>" + parsedJSON[i].type + "</td><td>" + parsedJSON[i].phone_number + "</td><td>" + parsedJSON[i].complaintSubmissionDate + "</td><td>" + parsedJSON[i].status + "</td></tr>";
        $("table tbody").append(markup);
		
	}
	}
	$(".data-page").show();
}

function displaySpecificIncident(incident_id,objectModal){
	$.ajax({
		url:"/user/fetch/data_with_id",
		data:"id="+incident_id,
		async : false,
		type:'get',
	  	success:function(response){
	  		$(objectModal).find(".modal-body").html(response);
			
	  	},
		error:function(error){
			//map.removeObjects(map.getObjects());
			$("#errorMessage").text(error.responseJSON.message);
		}
	});

}
