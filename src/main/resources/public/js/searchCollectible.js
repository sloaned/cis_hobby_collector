var collectibles;
function hide(){
    $("#searchButton").click();
}
function callSearch(){
      var search ={};
      search.category = $("#collectibleSearch").val().toLowerCase();
        search.color = $("#colorSearch").val().toLowerCase();
        search.condition = $("#conditionSearch").val().toLowerCase();
        search.age = $("#eraSearch").val().toLowerCase();
        search.description = $("#descriptionSearch").val().toLowerCase();
        search.name = $("#nameSearch").val().toLowerCase();
        search.keyword = $("#keywordsSearch").val().toLowerCase();
        var sold = $("#soldSearch").val();
        if(sold=="sold"){
            search.sold=true;
        }
        else if(sold=="notsold"){
            search.sold=false;
        }
        else{
            search.sold=null;
        }
        search.catalogNumber = $("#catalogNumberSearch").val().toUpperCase();
      $.ajax({
        url: '/collectibles/search',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(search)
    }).then(function(searchResult){
    	collectibles = searchResult;
    	replaceTable();
    	hide();
        console.log("Post successful")
    }, function(error){
      replaceTable();
        console.log(error);
    });
    }
function replaceTable(){
      $("tbody").children().remove();
     for (var i = 0; i < collectibles.length; i++) {
         addDataToRow(collectibles[i]);
     }
     $(".catalogNumber").click(update);
}

$(document).ready(function(){

var content = '<form class="container" id="searchForm" class="form-inline" role="form">\
  <div class="row">\
	<div class="form-group col-sm-4">\
      <label>Type:</label>\
      <input class="form-control" id="collectibleSearch" placeholder="type">\
    </div>\
    <div class="form-group col-sm-4">\
      <label>Color:</label>\
      <input type="text" class="form-control" id="colorSearch" placeholder="color">\
    </div>\
    <div class="form-group col-sm-4">\
      <label>Condition:</label>\
      <input type="text" class="form-control" id="conditionSearch" placeholder="condition">\
    </div>\
  </div>\
  <div class="row">\
    <div class="form-group col-sm-4">\
      <label>Era:</label>\
      <input type="text" class="form-control" id="eraSearch" placeholder="era">\
    </div>\
    <div class="form-group col-sm-4">\
      <label>Name:</label>\
      <input type="text" class="form-control" id="nameSearch" placeholder="name">\
    </div>\
    <div class="form-group col-sm-4">\
      <label>Keywords:</label>\
      <input type="text" class="form-control" id="keywordsSearch" placeholder="keyword">\
    </div>\
  </div>\
  <div class="row">\
     <div class="form-group col-sm-4">\
      <label>Catalog Number:</label>\
      <input type="text" class="form-control" id="catalogNumberSearch" placeholder="catalog number">\
    </div>\
      <div class="form-group col-sm-4">\
      <label>Description:</label>\
      <input type="text" class="form-control" id="descriptionSearch" placeholder="description">\
     </div>\
     <select id="soldSearch" class="col-sm-4">\
            <option value="select">Select Sold Status</option>\
            <option value="sold">Sold</option>\
            <option value="notsold">Not Sold</option>\
      </select>\
  </div>\
  <div class="row">\
    <button type="button" id="submitSearch" onclick="callSearch();" class="btn btn-default">Submit</button>\
</div>\
</form>';

    $('#searchButton').popover({container: 'body',title: "<h3 style='text-align:center'>Collectibles Search</h3><span class='close' onclick=hide()> Cancel &times;</span>",
    content: content, html: true, placement: "top"});
});
