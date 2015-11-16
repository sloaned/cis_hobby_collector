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
	var row = "<tr><td><div class='category'>" + capitalizeWord(collectible.category.category) + "</div></td><td><div class='color'>"
			+ capitalizeWord(collectible.color.color) + "</div></td><td><div class='condition'>" + capitalizeWord(collectible.condition.condition) + "</div></td><td><div class='age'>"
			+ capitalizeWord(collectible.age.age) + "</div></td><td title=\"" + capitalizeWord(collectible.description) + "\"><div class='description'>" + capitalizeWord(collectible.description).truncString(10) + "</div></td><td><div class='name'>"
			+ capitalizeWord(collectible.name) + "</div></td><td><div class='keywords'>";
	for (var i = 0; i < collectible.keywords.length; i++) {
		if (i === collectible.keywords.length - 1)
			row += capitalizeWord(collectible.keywords[i].keyword);
		else
			row += capitalizeWord(collectible.keywords[i].keyword) + ", ";
	}

	row += "</div></td><td><div class='sold'>"
			+ capitalizeWord(collectible.sold.toString()) + "</div></td><td><div class='CatalogNumber'>" + collectible.catalogueNumber.substring(0,3).toUpperCase() + collectible.catalogueNumber.substring(3) + "</div></td><td><div>"
			+ "<button class='editSubmitButton btn btn-default hidden' >Edit</button>" + "</div></td></tr>";

    $("tbody").append(row);
    }

function capitalizeWord(word){
	if (word !== null){
		if (word.length > 1){
			return word.substring(0,1).toUpperCase() + word.substring(1, word.length);
		}
		else{
			return word.toUpperCase();
		}
	}
}

String.prototype.truncString = function(length) {
    return this.length > length ? this.substring(0, length-1) + "..." : this;
}