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
        method: 'GET',
        data: search,
        contentType: "application/json",
        dataType: "json"
    }).then(function(){
    	alert("s");
        console.log("Post successful")
        location.reload(true);
    }, function(error){
    	alert("f");
        console.log(error);
    });
    }
	
$(document).ready(function(){
	
var content = '<form class="form-inline" role="form">\
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