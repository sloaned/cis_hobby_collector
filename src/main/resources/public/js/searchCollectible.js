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
    <button type="submit" class="btn btn-default">Submit</button>\
  </form>';
    $('#searchButton').popover({container: 'body',title: "<h3 style='text-align:center'>Collectibles Search</h3>", 
    content: content, html: true, placement: "top"}); 
});