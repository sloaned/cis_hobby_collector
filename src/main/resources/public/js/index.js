$(document).ready(function(){
	$.ajax({
		url : '/collectibles',
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
			+ collectible.sold + "</td><td>" + collectible.catalogueNumber + "</td><td>"
			+ "<button class='editButtin btn btn-default'>Edit</button>" + "</td></tr>";

	$("tbody").append(row);
}

function capitalizeWord(word){
	if (word !== null){
		if (word.length > 1){
			return word.substring(0,1).toUpperCase() + word.substring(1,word.length);
		}
		else{
			return word.toUpperCase();
		}
	}
}