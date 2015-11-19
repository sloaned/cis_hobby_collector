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
    var type = "<div class='category' id='"+collectible.id+"'>" + capitalizeWord(collectible.category.category) + "</div>";
    var colors = "<div class='color'>";
    	for(var i = 0; i < collectible.colors.length; i++){
    	    if(i === collectible.colors.length -1){
    	        colors += capitalizeWord(collectible.colors[i].color) + "</div>";
    	    }
    	    else{
    	        colors += capitalizeWord(collectible.colors[i].color) + ", ";
    	    }
    	}
    var condition = "<div class='condition'>" + capitalizeWord(collectible.condition.condition) + "</div>";
    var era = "<div class='age'>" + capitalizeWord(collectible.age.age) + "</div>";
    var description = "<div title='" + capitalizeWord(collectible.description) + "' class=\"ellipsis description\">" + capitalizeWord(collectible.description).makeEllipsis(15) + "</div>";
    var name = "<div class='name'>" + capitalizeWord(collectible.name) + "</div>";
    var soldStatus = "<div class='soldStatus'>" + capitalizeWord(collectible.sold.toString()) + "</div>";
    var keywords = "<div  class='keywords'>";
    for (var i = 0; i < collectible.keywords.length; i++) {
        if (i === collectible.keywords.length - 1)
            keywords += capitalizeWord(collectible.keywords[i].keyword) + "</div>";
        else
            keywords += capitalizeWord(collectible.keywords[i].keyword) + ", ";
    }
    var catalogNumber = "<div class='CatalogNumber'>" + collectible.catalogueNumber.substring(0,3).toUpperCase() + collectible.catalogueNumber.substring(3) + "</div>";
    var purchaseDate = "<div  class='purchaseDate'>" + collectible.purchaseDate + "</div>";
    var sellDate = "<div class='sellDate'>" + collectible.sellDate + "</div>";
    var row;

    if (collectible.sold == true){
        row = "<tr id=" + collectible.id + " class='alert-warning sold'><td>" + "<b>Catalog Number:</b>" + catalogNumber + "<b>Era:</b>" + era + "</td>" +
            "<td>" + "<b>Name:</b>" + name + "<b>Description:</b>" + description +"</td><td>" + "<b>Type:</b>" + type + "<b>Keywords:</b>" + keywords +
            "</td><td>" + "<b>Color:</b>" + colors + "<b>Sold Status:</b>" + soldStatus + "</td><td>" + "<b>Condition:</b>" + condition + "</td><td>" +
            "</td><td>" + "<b>Purchase Date:</b>" + purchaseDate + "<b>Sell Date</b>" + sellDate + "</td><td>" +
            "<button class='editSubmitButton btn btn-default hidden'>Done</button>" + "</td></tr>";
    }
    if (collectible.sold == false){
        row = "<tr id=" + collectible.id + " class='alert-warning notSold'><td>" + "<b>Catalog Number:</b>" + catalogNumber + "<b>Era:</b>" + era + "</td>" +
            "<td>" + "<b>Name:</b>" + name + "<b>Description:</b>" + description +"</td><td>" + "<b>Type:</b>" + type + "<b>Keywords:</b>" + keywords +
            "</td><td>" + "<b>Color:</b>" + colors + "<b>Sold Status:</b>" + soldStatus + "</td><td>" + "<b>Condition:</b>" + condition + "</td><td>" +
            "</td><td>" + "<b>Purchase Date:</b>" + purchaseDate + "<b>Sell Date:</b> <div class='sellDate'>n/a </div> </td><td>" +
            "<button class='editSubmitButton btn btn-default hidden'>Done</button>" + "</td></tr>";
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
      "showDuration": "3000000",
      "hideDuration": "1000000",
      "timeOut": "50000000000",
      "extendedTimeOut": "10000000",
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