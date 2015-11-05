$(document).ready(function(){
	$.ajax({
		url : '/collectibles', // TODO: change this to what it actually is.
		method : 'GET'
	}).then(function(collectibles) {
		$("tbody").children().remove();
		for (var i = 0; i < collectibles.length; i++) {
			addDataToRow(collectibles[i]);
		}
	});
});

function addDataToRow(collectible){
	var row = "<tr><td>" + collectible.category + "</td><td>"
			+ collectible.color + "</td><td>" + collectible.condition + "</td><td>"
			+ collectible.age + "</td><td>" + collectible.description + "</td><td>"
			+ collectible.name + "</td><td>" + collectible.keywords + "</td><td>"
			+ collectible.sold + "</td><td>" + collectible.catalogueNumber + "</td></tr>";

	$("tbody").append(row);
}