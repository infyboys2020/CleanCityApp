locationList = '';
index = '';

$(document).ready(function() {
});

function submitForm(){
		$.ajax({
			url:"/getComplaintList",
			type:'get',
		  	success:function(json){
				$("#message").text(json);
				$("#errorMessage").text('');
				map.removeObjects(map.getObjects());
				populateLocation();
		  	},
			error:function(error){
				map.removeObjects(map.getObjects());
				$("#errorMessage").text(error.responseText);
			}
		});
}

function populateLocation(){
	locationList = document.getElementById("message").innerHTML;
	if(undefined != locationList){
        locationList = jQuery.parseJSON(locationList);
		map.setCenter({lat:parseFloat(locationList[0].latitude), lng:parseFloat(locationList[0].longitude)});
        for (var i = 0; i < locationList.length; i++) {
			index = i;
			var marker = new H.map.DomMarker({lat:parseFloat(locationList[i].latitude), lng:parseFloat(locationList[i].longitude)},{
			   icon: getDomMarker(i)
			 });
			map.addObject(marker);

        }
	}
}

function addBubble(){
	ui.addBubble(new H.ui.InfoBubble({lat:parseFloat(locationList[index].latitude), lng:parseFloat(locationList[index].longitude)}, {
      content: "<a target='_blank' href='https://" + locationList[index].address + "'>"+ locationList[index].address +"</a><br>" + locationList[index].address + "<br>" + locationList[index].name 
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

  innerElement.style.color = 'red';
  innerElement.style.backgroundColor = '#c7c7de';
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
	
	outerElement.setAttribute("data-toggle", "tooltip");
	outerElement.setAttribute("title", locationList[index].address);
	
  outerElement.appendChild(innerElement);

  // Add text to the DOM element
  innerElement.innerHTML = locationList[index].type;

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