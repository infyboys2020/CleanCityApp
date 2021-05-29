/**
 * Moves the map to display over Berlin
 *
 * @param  {H.Map} map      A HERE Map instance within the application
 */
function moveMapToBBSR(map){
  map.setCenter({lat:20.2961, lng:85.8245});
  map.setZoom(10);
}

/**
 * Boilerplate map initialization code starts below:
 */

//Step 1: initialize communication with the platform
// In your own code, replace variable window.apikey with your own apikey
var platform = new H.service.Platform({
  apikey: window.apikey
});
var defaultLayers = platform.createDefaultLayers();

//Step 2: initialize a map - this map is centered over Europe
var map = new H.Map(document.getElementById('map'),
  defaultLayers.vector.normal.map,{
  center: {lat:50, lng:5},
  zoom: 4,
  pixelRatio: window.devicePixelRatio || 1
});
 // Attach an event listener to map display
  // obtain the coordinates and display in an alert box.
map.addEventListener('tap', function (evt) {
    var coord = map.screenToGeo(evt.currentPointer.viewportX,
            evt.currentPointer.viewportY);
	document.getElementsByName("longitude")[0].value = coord.lng;
	document.getElementsByName("latitude")[0].value = coord.lat;
	addInfoBubble(map, coord.lat, coord.lng);
    console.log('Clicked at ' + Math.abs(coord.lat.toFixed(4)) +
        ((coord.lat > 0) ? 'N' : 'S') +
        ' ' + Math.abs(coord.lng.toFixed(4)) +
         ((coord.lng > 0) ? 'E' : 'W'));
});
// add a resize listener to make sure that the map occupies the whole container
window.addEventListener('resize', () => map.getViewPort().resize());

//Step 3: make the map interactive
// MapEvents enables the event system
// Behavior implements default interactions for pan/zoom (also on mobile touch environments)
var behavior = new H.mapevents.Behavior(new H.mapevents.MapEvents(map));

// Create the default UI components
var ui = H.ui.UI.createDefault(map, defaultLayers);

// Now use the map as required...
window.onload = function () {
	//populateLocation();
	moveMapToBBSR(map);
}

function addInfoBubble(map, latitude, longitude) {
  var group = new H.map.Group();
  map.removeObjects(map.getObjects());
  map.addObject(group);
  var marker = new H.map.Marker({lat: latitude, lng: longitude});
  group.addObject(marker);
}