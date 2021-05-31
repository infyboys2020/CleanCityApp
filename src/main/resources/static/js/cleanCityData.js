$(document).ready(function() {
		
	populateTable(data);
	
	$("#detail_action").click(function(){
		updateStatus(id,$(this).val());
});
		
	$('#orderModal').on('show.bs.modal', function (event) {
			  var myVal = $(event.relatedTarget).data('id');
			  displaySpecificIncident(myVal,$(this));
			  //$(this).find(".modal-body").text(myVal);
			});
		
		
		
});


function populateTable(parsedJSON){
	
	shareInfoLen = Object.keys(parsedJSON).length;
	var table = document.getElementById("data-table");
	var row="";
	for(var i=0;i<shareInfoLen;i++){
		var markup = "<tr data-toggle='modal' data-id="+parsedJSON[i].id+" data-target='#orderModal'><td>" + parsedJSON[i].id + "</td><td>" + parsedJSON[i].name + "</td><td>" + parsedJSON[i].address + "</td><td>" + parsedJSON[i].type + "</td><td>" + parsedJSON[i].phone_number + "</td><td>" + parsedJSON[i].complaintSubmissionDate + "</td><td>" + parsedJSON[i].status + "</td></tr>";
        $("table tbody").append(markup);
		
	}
}

function displaySpecificIncident(incident_id,objectModal){
	$.ajax({
		url:"/admin/fetch/data_with_id",
		data:"id="+incident_id,
		async : false,
		type:'get',
	  	success:function(response){
	  		$(objectModal).find(".modal-body").html(response);
			
	  	},
		error:function(error){
			map.removeObjects(map.getObjects());
			$("#errorMessage").text(error.responseText);
		}
	});
}
	
	function updateStatus(incident_id,status){
		$.ajax({
			url:"/admin/fetch/updateStatus",
			data:"id="+incident_id+"&status="+status,
			async : false,
			type:'get',
		  	success:function(response){
		  		console.log(response);
		  		$("#success-shown").show();
		  		$("#detail_action").attr("disabled", true);
				
		  	},
			error:function(error){
				map.removeObjects(map.getObjects());
				$("#errorMessage").text(error.responseText);
			}
		});

}
