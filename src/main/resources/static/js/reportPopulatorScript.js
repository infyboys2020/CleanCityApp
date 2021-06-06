locationList = '';
index = '';

$(document).ready(function() {
	$("#maplink").click(function(e){
            e.preventDefault();
 			$("#reportgraph").hide();
            $("#reportmap").show();
        });
	$("#graphlink").click(function(e){
            e.preventDefault();
 			$("#reportmap").hide();
            $("#reportgraph").show();
        });
});

function submitForm(){
	getmapdata();
	getgraphdatabyType();
	getgraphdatabyPIN();
}

function backtoForm(){
	$("#report_page").hide();
	$("#login_form").show();
}

function getmapdata(){
	$.ajax({
			url:"/user/getComplaintList",
			type:'get',
			data:"pin="+document.getElementById("pin").value + "&start_date=" + document.getElementById("start_date").value
					+ "&end_date=" + document.getElementById("end_date").value,
		  	success:function(json){
				$("#mapmessage").text(json);
				$("#errorMessage").text('');
				map.removeObjects(map.getObjects());
				populateLocation();
				$("#login_form").hide();
				$("#report_page").show();
		  	},
			error:function(error){
				map.removeObjects(map.getObjects());
				$("#errorMessage").text("Could not find any data to populate");
			}
		});
}

function getgraphdatabyType(){
	$.ajax({
			url:"/user/getComplaintListGrouped",
			type:'get',
			data:"pin="+document.getElementById("pin").value + "&start_date=" + document.getElementById("start_date").value
					+ "&end_date=" + document.getElementById("end_date").value + "&group=" + "type",
		  	success:function(json){
				$("#errorMessage").text('');
				populatechart(json, $("#containertype"),"type", "Incidents by criteria");
		  	},
			error:function(error){
				$("#errorMessage").text("Could not find any data to populate");
			}
		});
}
function getgraphdatabyPIN(){
	$.ajax({
			url:"/user/getComplaintListGrouped",
			type:'get',
			data:"pin="+document.getElementById("pin").value + "&start_date=" + document.getElementById("start_date").value
					+ "&end_date=" + document.getElementById("end_date").value + "&group=" + "pin",
		  	success:function(json){
				$("#errorMessage").text('');
				populatechart(json, $("#containerpin"),"pin", "Incidents by PinCode");
		  	},
			error:function(error){
				$("#errorMessage").text("Could not find any data to populate");
			}
		});
}

function populateLocation(){
	locationList = document.getElementById("mapmessage").innerHTML;
	if(undefined != locationList && locationList !="[]"){
        locationList = jQuery.parseJSON(locationList);
		//map.setCenter({lat:parseFloat(locationList[0].latitude), lng:parseFloat(locationList[0].longitude)});
		var locarray = [];
		var arrindex=0; 
        for (var i = 0; i < locationList.length; i++) {
			index = i;
			var marker = new H.map.DomMarker({lat:parseFloat(locationList[i].latitude), lng:parseFloat(locationList[i].longitude)},{
			   icon: getDomMarker(i)
			 });
			//map.addObject(marker);
			locarray[arrindex++] = marker;
        }

		var group = new H.map.Group();
		group.addObjects(locarray);
		map.addObject(group);
		map.getViewModel().setLookAtData({
		   bounds: group.getBoundingBox()
		 });
	}else{
		$("#errorMessage").text("Could not find any data to populate");
	}
}

function addBubble(){
	ui.addBubble(new H.ui.InfoBubble({lat:parseFloat(locationList[this.getAttribute("myindex")].latitude),
				lng:parseFloat(locationList[this.getAttribute("myindex")].longitude)}, {
      content:  "Reported for: "+ locationList[this.getAttribute("myindex")].type + "<br>on: "+
				 locationList[this.getAttribute("myindex")].complaintSubmissionDate +"<br>Status: " +
				 locationList[this.getAttribute("myindex")].status +
				"<br><a target='_blank' href='/user/fetch/data_with_id?id=" + locationList[this.getAttribute("myindex")].id + "'>View Details</a>"
    }));
}


function getDomMarker(index) {
  var outerElement = document.createElement('div'),
      innerElement = document.createElement('div');

  outerElement.style.userSelect = 'none';
  outerElement.style.webkitUserSelect = 'none';
  outerElement.style.msUserSelect = 'none';
  outerElement.style.mozUserSelect = 'none';
  outerElement.style.cursor = 'default';

  
  innerElement.style.border = '2px solid black';
  innerElement.style.font = 'normal 12px arial';
  innerElement.style.lineHeight = '12px'

  innerElement.style.paddingTop = '2px';
  innerElement.style.paddingLeft = '4px';
  innerElement.style.width = '20px';
  innerElement.style.height = '20px';

  // add negative margin to inner element
  // to move the anchor to center of the div
  innerElement.style.marginTop = '-10px';
  innerElement.style.marginLeft = '-10px';

	if(locationList[index].status == "In-Progress"){
		innerElement.style.color = 'white';
	  	innerElement.style.backgroundColor = 'red';
	}else if(locationList[index].status == "Acknowledged"){
		innerElement.style.color = 'white';
	  	innerElement.style.backgroundColor = '#b0b13b';
	}else if(locationList[index].status == "Done"){
		innerElement.style.color = 'white';
	  	innerElement.style.backgroundColor = 'green';
	}else{
		innerElement.style.color = 'black';
	  	innerElement.style.backgroundColor = 'white';
	}
	
	outerElement.setAttribute("data-toggle", "tooltip");
	outerElement.setAttribute("title", locationList[index].address);
	outerElement.setAttribute("myindex", index);
	
  outerElement.appendChild(innerElement);

  // Add text to the DOM element
  innerElement.innerHTML = locationList[index].type[0].toUpperCase();

  function changeOpacity(evt) {
    evt.target.style.opacity = 0.6;
  };

  function changeOpacityToOne(evt) {
    evt.target.style.opacity = 1;
  };

  //create dom icon and add/remove opacity listeners
  var domIcon = new H.map.DomIcon(outerElement, {
    // the function is called every time marker enters the viewport
    onAttach: function(clonedElement, domIcon, domMarker) {
      clonedElement.addEventListener('mouseover', changeOpacity);
	  clonedElement.addEventListener('click', addBubble);
      clonedElement.addEventListener('mouseout', changeOpacityToOne);
    },
    // the function is called every time marker leaves the viewport
    onDetach: function(clonedElement, domIcon, domMarker) {
      clonedElement.removeEventListener('mouseover', changeOpacity);
      clonedElement.removeEventListener('mouseout', changeOpacityToOne);
    }
  });

	return domIcon;

  // Marker for Chicago Bears home
  /*var bearsMarker = new H.map.DomMarker({lat: lat, lng: long}, {
    icon: domIcon
  });*/
	
  //map.addObject(bearsMarker);
}

function populatechart(json, container, group, title) {

  // set the data
	var msg = jQuery.parseJSON(json);
	var data =[];
	
	container.html('');
	if(msg.length != 0){
			msg.forEach(function(value, index, array) {
			  		var my_object = {}; 
			
			       my_object.x = value[group];
			       my_object.value = value.count;
					data.push(my_object);
			})
		
		  // create the chart
		  var chart = anychart.pie();
		
		  // set the chart title
		  chart.title(title);
		
		  // add the data
		  chart.data(data);
		  
		  // set legend position
		  chart.legend().position("right");
		  // set items layout
		  chart.legend().itemsLayout("vertical");  
			chart.background().fill("none");
		
		  // display the chart in the container
		  chart.container(container[0].id);
		  chart.draw();
		//$("#reportgraph").show();
	}else{
		$("#errorMessage").text("No data found for selected criteria");
	}

}