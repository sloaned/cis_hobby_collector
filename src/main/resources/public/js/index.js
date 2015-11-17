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
        $(".catalogNumber").click(update);
    });
}

function addDataToRow(collectible){
    var type = "<div class='alert-warning category' id='"+collectible.id+"'>" + capitalizeWord(collectible.category.category) + "</div>";
    var color = "<div class='color'>" + capitalizeWord(collectible.color.color) + "</div>";
    var condition = "<div class='condition'>" + capitalizeWord(collectible.condition.condition) + "</div>";
    var era = "<div class='age'>" + capitalizeWord(collectible.age.age) + "</div>";
    var description = "<div title=" + capitalizeWord(collectible.description) + " class=\"ellipsis description\">" + capitalizeWord(collectible.description).makeEllipsis(15) + "</div>";
    var name = "<div class='name'>" + capitalizeWord(collectible.name) + "</div>";
    var soldStatus = "<div class='sold'>" + capitalizeWord(collectible.sold.toString()) + "</div>";
    var keywords = "<div class='keywords'>";
    for (var i = 0; i < collectible.keywords.length; i++) {
        if (i === collectible.keywords.length - 1)
            keywords += capitalizeWord(collectible.keywords[i].keyword) + "</div>";
        else
            keywords += capitalizeWord(collectible.keywords[i].keyword) + ", ";
    }
    var catalogNumber = "<div class='displayCatalogNumber'>" + collectible.catalogueNumber.substring(0,3).toUpperCase() + collectible.catalogueNumber.substring(3) + "</div>";
    var purchaseDate = "<div class='purchaseDate'>" + collectible.purchaseDate + "</div>";
    var sellDate = "<div class='sellDate'>" + collectible.sellDate + "</div>";

    var row;

    if (collectible.sold == true){
        row = "<tr id=" + collectible.id + " class='alert-warning sold'><td>" + "<b>Catalog Number:</b>" + catalogNumber + "<b>Era:</b>" + era + "</td>" +
            "<td>" + "<b>Name:</b>" + name + "<b>Description:</b>" + description +"</td><td>" + "<b>Type:</b>" + type + "<b>Keywords:</b>" + keywords +
            "</td><td>" + "<b>Color:</b>" + color + "<b>Sold Status:</b>" + soldStatus + "</td><td><div>" + "<b>Condition</b>" + condition + "</td><td><div>" +
            "</td><td>" + "<b>Purchase Date:</b>" + purchaseDate + "<b>Sell Date</b>" + sellDate + "</td><td><div>" +
            "<button class='editSubmitButton btn btn-default hidden'>Done</button>" + "</div></td></tr>";
    }
    if (collectible.sold == false){
        row = "<tr id=" + collectible.id + " class='alert-warning notSold'><td>" + "<b>Catalog Number:</b>" + catalogNumber + "<b>Era:</b>" + era + "</td>" +
            "<td>" + "<b>Name:</b>" + name + "<b>Description:</b>" + description +"</td><td>" + "<b>Type:</b>" + type + "<b>Keywords:</b>" + keywords +
            "</td><td>" + "<b>Color:</b>" + color + "<b>Sold Status:</b>" + soldStatus + "</td><td><div>" + "<b>Condition</b>" + condition + "</td><td><div>" +
            "</td><td>" + "<b>Purchase Date:</b>" + purchaseDate + "<b>Sell Date:</b> <div>n/a </div> </td><td><div>" +
            "<button class='editSubmitButton btn btn-default hidden'>Done</button>" + "</div></td></tr>";
    }

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