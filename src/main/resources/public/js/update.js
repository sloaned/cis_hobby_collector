function update(){
    //if there is already a row beeing edited then dont make another row editable
    if($(".editField").length !== 0) return;
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
    $(document).mouseup(function(e){
            if (!$(e.target).hasClass("editField"))
                loadTable();
           console.log(e.target);
        $(document).off("mouseup");
        });
}
function updated(){
    var valid = validate();
    var collectible = {};
    collectible.id = $(".name .editField").parent().parent().parent().attr('id');
    collectible.name = $(".name .editField").val().toLowerCase();
    collectible.age = $(".age .editField").val().toLowerCase();
    collectible.description = $(".description .editField").val().toLowerCase();
    collectible.category = $(".category .editField").val().toLowerCase();;
    collectible.condition = $(".condition .editField").val().toLowerCase();;
    collectible.color = $(".color .editField").val().toLowerCase();;
    collectible.keywords = getKeywords();
    collectible.sold = $("#inputSoldStatus").find("button").text().toLowerCase().trim();
    collectible.catalogueNumber = $(".catalogNumber .editField").val().toLowerCase();

    if (valid){
        $.ajax({
            url: '/collectible/'+collectible.id,
            method: 'PUT',
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
    var valid = false;

    var name = $(".name .editField").val().toLowerCase();
    var age = $(".age .editField").val().toLowerCase();
    var description = $(".description .editField").val().toLowerCase();
    var category = $(".category .editField").val().toLowerCase();
    var condition = $(".condition .editField").val().toLowerCase();
    var color = $(".color .editField").val().toLowerCase();
    var keywords = getKeywords();
    var sold = $("#inputSoldStatus").find("button").text().toLowerCase().trim();
    var catalogNumber = $(".catalogNumber .editField").val().toLowerCase();

    valid = isValid(name,".name",255) &&
    isValid(age,".age",255) &&
    isValid(description,".description",1000) &&
    isValid(category,".category",255) &&
    isValid(condition,".condition",255) &&
    isValid(color,".color",255) &&
    isValid(catalogNumber,".catalogNumber",16) &&
    isKeywordsValid(keywords);

    function isValid(text,where,length){
        if(text == null || text == ""){
            $(where+" .editField").addClass("error");
            toast(where.replace('.','')+" cannot be null")
            return false;
        }
        else if(text.length > length){
            $(where+" .editField").addClass("error");
            toast(where.replace('.','')+" is too long")
             return false;
        }
        else
            $(where+" .editField").removeClass("error");
          return true;
    }

    function isKeywordsValid(keywords){
        if(keywords.length < 3 ){
            $(".keywords .editField").addClass("error");
            toast("Must have at least three keywords")
             return false;
        }
         return true;
    }
    return valid;
}

function getKeywords(){
    var keywords =  $(".keywords .editField").val().toLowerCase();
    keywords = keywords.replaceAll(' ',',');
    keywords = keywords.split(',');
    keywords = keywords.clean("");
    return keywords;
}

Array.prototype.clean = function(deleteValue) {
  for (var i = 0; i < this.length; i++) {
    if (this[i] == deleteValue) {
      this.splice(i, 1);
      i--;
    }
  }
  return this;
};
/**
 * ReplaceAll by Fagner Brack (MIT Licensed)
 * Replaces all occurrences of a substring in a string
 */
String.prototype.replaceAll = function( token, newToken, ignoreCase ) {
    var _token;
    var str = this + "";
    var i = -1;

    if ( typeof token === "string" ) {
        if ( ignoreCase ) {
            _token = token.toLowerCase();
            while( (
                i = str.toLowerCase().indexOf(
                    token, i >= 0 ? i + newToken.length : 0
                ) ) !== -1
            ) {
                str = str.substring( 0, i ) +
                    newToken +
                    str.substring( i + token.length );
            }
        } else {
            return this.split( token ).join( newToken );
        }
    }
    return str;
};