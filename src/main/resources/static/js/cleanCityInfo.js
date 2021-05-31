$(document).ready(function() {
		
		document.getElementById("image-holder-place").src = photo;
		$("#incident-id").html("Incident Number: "+id);
		$("#name-of-reporter").html("Name of the reporting person: "+name);
		$("#address-of-reporter").html("Address of the incident: "+address);
		$("#contact-of-reporter").html("Contact number: "+phone);
		$("#address-pin").html("Pin number of the area: "+pin);
		$("#report-status").html("Status of the incident: "+status);
		$("#type-of-incident").html("Type of issue: " +type);
		$("#reporting-date").html("Reprting date: "+ComplaintSubmissionDate);
		$("#detail_action").attr("disabled", false);
		$("#success-shown").hide();
		
		if(status!=undefined){
			if(status==="In-Progress"){
				$("#detail_action").val("Acknowledged");
				$("#detail_action").html("Acknowledge");
			}
			else if(status==="Acknowledged"){
				$("#detail_action").val("Done");
				$("#detail_action").html("Done");
			}
			else if(status==="Done"){
				$("#detail_action").hide();
			}
		}
});

