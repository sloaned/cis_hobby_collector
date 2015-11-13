$(document).ready(function(){
	$.ajax({
		url : '/collectibles',
		method : 'GET'
	}).then(function(collectibles) {
		$("tbody").children().remove();
		for (var i = 0; i < collectibles.length; i++) {
			addDataToRow(collectibles[i]);
		}
		$(".catalogNumber").click(update)
	});

});

function addDataToRow(collectible){
	var row = "<tr><td>" + capitalizeWord(collectible.category.category) + "</td><td>"
			+ capitalizeWord(collectible.color.color) + "</td><td>" + capitalizeWord(collectible.condition.condition) + "</td><td>"
			+ capitalizeWord(collectible.age.age) + "</td><td>" + capitalizeWord(collectible.description) + "</td><td>"
			+ capitalizeWord(collectible.name) + "</td><td>";
	for (var i = 0; i < collectible.keywords.length; i++) {
		if (i === collectible.keywords.length - 1)
			row += capitalizeWord(collectible.keywords[i].keyword);
		else
			row += capitalizeWord(collectible.keywords[i].keyword) + ", ";
	}

	row += "</td><td>"
			+ capitalizeWord(collectible.sold.toString()) + "</td><td class=\"catalogNumber\">" + collectible.catalogueNumber.substring(0,3).toUpperCase() + collectible.catalogueNumber.substring(3) + "</td>"
			+ "</tr>";

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