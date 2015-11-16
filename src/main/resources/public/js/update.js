function update(){
    //if already changed td to input then don't do it again again
    if($(this).children().hasClass("editField"))return;
    //set row to the row of the CatalogNumber clicked
    row = $(this.parentNode.parentNode);
   // console.log(row);


    //change all td to input boxes
    row.children().each(function(){
        //set this to what this is (the div)
        div=$(this.children);

        //if this is the submit button we don't want to change it to a input field however we do want to show it
        if($(div).children().hasClass("editSubmitButton")){
            $(div).children().toggleClass("hidden");
            return;
        }

        //we want a drop down instead of an inputField here
        if($(div).hasClass("sold")){
            var isSold = $(div).text().toLowerCase() == "true"? "<option selected='selected'>true</option> <option>false</option>":"<option >true</option> <option selected='selected'>false</option>";
            $(div).html("<select class=\"editField\"> "+ isSold+ "</select>");
            return;
        }

        //we need to grab the full description from the title of the parent
        if($(div).hasClass("description")){

            $(div).html("<input class=\" form-control editField\" value=\""+$(div).parent().attr('title') +"\">");
            return;
        }

        text = $(div).text();
        $(div).html("<input class=\"form-control editField\"type=\"text\" value=\""+ text +"\">");
    });
    $(".editSubmitButton").click(updated)
}
function updated(){
    validate();
    var collectible = {};
            collectible.id = $(".name .editField").parent().parent().parent().attr('id');
            collectible.name = $(".name .editField").val().toLowerCase();
            collectible.age = $(".age .editField").val().toLowerCase();
            collectible.description = $(".description .editField").val().toLowerCase();
            collectible.category = $(".category .editField").val().toLowerCase();;
            collectible.condition = $(".condition .editField").val().toLowerCase();;
            collectible.color = $(".color .editField").val().toLowerCase();;
            collectible.keywords = iCanHazKeywords();
            collectible.sold = $("#inputSoldStatus").find("button").text().toLowerCase().trim();
            collectible.catalogueNumber = $(".catalogNumber .editField").val().toLowerCase();
            console.log(collectible);
            if (false){
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
function validate(){
    console.log("hi")
    var name = $(".name .editField").val().toLowerCase();
    var age = $(".age .editField").val().toLowerCase();
    var description = $(".description .editField").val().toLowerCase();
    var category = $(".category .editField").val().toLowerCase();
    var condition = $(".condition .editField").val().toLowerCase();
    var color = $(".color .editField").val().toLowerCase();
    var keywords = iCanHazKeywords();
    var sold = $("#inputSoldStatus").find("button").text().toLowerCase().trim();
    var catalogNumber = $(".catalogNumber .editField").val().toLowerCase();

    isValid(name,".name",255);
    isValid(age,".age",255);
    isValid(description,".description",1000);
    isValid(category,".category",255);
    isValid(condition,".condition",255);
    isValid(color,".color",255);
    isValid(catalogNumber,".catalogNumber",16);

    function isValid(text,where,length){
        if(text == null || text == ""){
            $(where+" .editField").addClass("error");
        }
        else if(text.length > length){
            $(where+" .editField").addClass("error")
        }
        else
            $(where+" .editField").removeClass("error");
    }
}

function getKeywords(){

}