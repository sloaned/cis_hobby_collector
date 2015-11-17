var collectibles;
function callSearch(){
    	alert();
    	var search = {};
    	search.category = $("#collectibleSearch").val();
        search.color = $("#colorSearch").val(); 
        search.condition = $("#conditionSearch").val();
        search.age = $("#eraSearch").val();
        search.description = $("#descriptionSearch").val();
        search.name = $("#nameSearch").val();
        search.keyword = $("#keywordsSearch").val();
        search.sold = $("#soldSearch").val();
        search.catalogNumber = $("#catalogNumberSearch").val();
        alert(search);
    	$.ajax({
        url: '/collectibles/{search}',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(search)
    }).then(function(searchResult){
    	collectibles = searchResult;
    	alert("s");
        console.log("Post successful")
        location.reload(true);
    }, function(error){
    	alert("f");
        console.log(error);
    });
    }
function replaceTable(e){
	alert("remove");
	 $("tbody").children().remove();
     for (var i = 0; i < collectibles.length; i++) {
         addDataToRow(collectibles[i]);
     }
	 e.preventDefault();
}

function addDataToRow(collectible){
	var row = "<tr><td><div>" + capitalizeWord(collectible.category.category) + "</div></td><td><div>"
			+ capitalizeWord(collectible.color.color) + "</div></td><td><div>" + capitalizeWord(collectible.condition.condition) + "</div></td><td><div>"
			+ capitalizeWord(collectible.age.age) + "</div></td><td title=\"" + capitalizeWord(collectible.description) + "\"><div>" + capitalizeWord(collectible.description).truncString(10) + "</div></td><td><div>"
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
	
$(document).ready(function(){
	
var content = '<form id="searchForm" onsubmit="replaceTable()" class="form-inline" role="form">\
    <div class="form-group">\
      <label>Collectible:</label>\
      <input class="form-control" id="collectibleSearch" placeholder="collectible">\
    </div>\
    <div class="form-group">\
      <label>Color:</label>\
      <input type="text" class="form-control" id="colorSearch" placeholder="color">\
    </div>\
    <div class="form-group">\
      <label>Condition:</label>\
      <input type="text" class="form-control" id="conditionSearch" placeholder="condition">\
    </div>\
    <div class="form-group">\
      <label>Era:</label>\
      <input type="text" class="form-control" id="eraSearch" placeholder="era">\
    </div>\
    <div class="form-group">\
      <label>Name:</label>\
      <input type="password" class="form-control" id="nameSearch" placeholder="name">\
    </div>\
    <div class="form-group">\
      <label>Keywords:</label>\
      <input type="password" class="form-control" id="keywordsSearch" placeholder="keyword">\
    </div>\
     <div class="form-group">\
      <label>Catalog Number:</label>\
      <input type="text" class="form-control" id="catalogNumberSearch" placeholder="catalog number">\
    </div>\
	<div class="form-group">\
      <label>Description:</label>\
      <input type="text" class="form-control" id="descriptionSearch" placeholder="description">\
  </div>\
   <select id="soldSearch">\
  		<option value="select">Select</option>\
  		<option value="sold">Sold</option>\
  		<option value="notsold">Not Sold</option>\
	</select>\
    <button type="submit" id="submitSearch" onclick="callSearch();" class="btn btn-default">Submit</button>\
  </form>';

    $('#searchButton').popover({container: 'body',title: "<h3 style='text-align:center'>Collectibles Search</h3>", 
    content: content, html: true, placement: "top"});  
});