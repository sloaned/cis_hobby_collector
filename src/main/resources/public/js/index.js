$(document).ready(function(){
    loadTable();
});

function loadTable() {
    $.ajax({
        url : '/collectibles',
        method : 'GET'
    }).then(function(collectibles) {
        $("tbody").children().remove();
        for (var i = 0; i < collectibles.length; i++) {
            addDataToRow(collectibles[i]);
        }
    });
}

function addDataToRow(collectible){
	var row = "<tr><td><div>" + capitalizeWord(collectible.category.category) + "</div></td><td><div>"
			+ capitalizeWord(collectible.color.color) + "</div></td><td><div>" + capitalizeWord(collectible.condition.condition) + "</div></td><td><div>"
			+ capitalizeWord(collectible.age.age) + "</div></td><td title=\"" + capitalizeWord(collectible.description) + "\"><div class=\"ellipsis\">" + capitalizeWord(collectible.description).makeEllipsis(15) + "</div></td><td><div>"
			+ capitalizeWord(collectible.name) + "</div></td><td><div>";
	for (var i = 0; i < collectible.keywords.length; i++) {
		if (i === collectible.keywords.length - 1)
			row += capitalizeWord(collectible.keywords[i].keyword);
		else
			row += capitalizeWord(collectible.keywords[i].keyword) + ", ";
	}

	row += "</div></td><td><div>"
			+ capitalizeWord(collectible.sold.toString()) + "</div></td><td><div class='displayCatalogNumber'>" + collectible.catalogueNumber.substring(0,3).toUpperCase() + collectible.catalogueNumber.substring(3) + "</div></td><td><div>"
			+ "<button class='editButton btn btn-default'>Edit</button>" + "</div></td></tr>";

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

String.prototype.makeEllipsis = function(length) {
    return this.length > length ? this.substring(0, length-1) + "&hellip;" : this;
}

function toast(message, successful) {
    toastr.options = {
      "closeButton": false,
      "debug": false,
      "newestOnTop": false,
      "progressBar": false,
      "positionClass": "toast-top-center",
      "preventDuplicates": true,
      "onclick": null,
      "showDuration": "300",
      "hideDuration": "1000",
      "timeOut": "5000",
      "extendedTimeOut": "1000",
      "showEasing": "swing",
      "hideEasing": "linear",
      "showMethod": "fadeIn",
      "hideMethod": "fadeOut",
      'body-output-type': 'trustedHtml'
    }

    var status;
    status = successful ? "Success" : "Error";

    toastr[status.toLowerCase()](message, status);
}