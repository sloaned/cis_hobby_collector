function update(){
    //if already changed td to input then don't do it again again
    if($(this).children().hasClass("editField"))return;
    //set row to the row of the CatalogNumber clicked
    row = $(this.parentNode.parentNode);
   // console.log(row);
    //console.log(self)

    //change all td to input boxes
    row.children().each(function(){
        //set this to what this is (the div)
        div=$(this.children);

        //if this is the submit button we don't want to change it to a input field however we do want to show it
        if($(div).children().hasClass("editSubmitButton")){
            $(div).children().toggleClass("hidden");
            return;
        }

        if($(div).hasClass("sold")){
            var isSold = $(div).text().toLowerCase() == "true"? "<option selected='selected'>true</option> <option>false</option>":"<option >true</option> <option selected='selected'>false</option>";
            console.log(isSold);
            $(div).html("<select class=\"editField\" value=\""+ isSold +"\"> "+ isSold+ "</select>");
            return;
        }

        text = $(div).text();
        $(div).html("<input class=\"editField\"type=\"text\" value=\""+ text +"\">");
    });
    $(".editSubmitButton").click(updated)
}
function updated(){
    console.log("hi");
    var collectible = {};
            collectible.name = $("#inputName").val().toLowerCase();
            collectible.age = age;
            collectible.description = $("#inputDescription").val().toLowerCase();
            collectible.category = category;
            collectible.condition = condition;
            collectible.color = color;
            collectible.keywords = iCanHazKeywords();
            collectible.sold = $("#inputSoldStatus").find("button").text().toLowerCase().trim();
            collectible.catalogueNumber = $("#inputCatalogNumber").val();
            console.log(collectible);
            if (isValid){
                $.ajax({
                    url: '/collectible',
                    method: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(collectible)
                }).then(function(){
                    console.log("Post successful")
                    location.reload(true);
                }, function(error){
                    console.log(error);
                });
            }
}