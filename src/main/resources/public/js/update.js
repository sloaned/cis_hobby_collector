function update(){

    //if there is already a row being edited then don't make another row editable
    if($(".editField").length !== 0) return;
    //if already changed td to input then don't do it again again
    if($(this).children().hasClass("editField"))return;
    //set row to the row of the CatalogNumber clicked
    row = $(this.parentNode.parentNode);
    row.addClass("editing");
    //console.log(row.find("div"))
   // console.log(row);

    //change all td to input boxes
    row.children().each(function(){
        $(this).children().each(function(){
        //set this to what this is (the div)
        div=$(this);
        if(div.is('b')) return;

        //if this is the submit button we don't want to change it to a input field however we do want to show it
        if($(div).hasClass("editSubmitButton")){
            $(div).toggleClass("hidden");
            return;
        }

        //we want a drop down instead of an inputField here
        if($(div).hasClass("soldStatus")){
            var isSold = $(div).text().toLowerCase() === "true"? "<option selected='selected'>true</option> <option>false</option>":"<option >true</option> <option selected='selected'>false</option>";
            $(div).html("<select class=\"editField\"> "+ isSold+ "</select>");
            return;
        }

        //we need to grab the full description from the title of the parent
        if($(div).hasClass("description")){
            $(div).html("<input class=\" form-control editField\" value=\""+$(div).attr('title') +"\">");
            return;
        }
        if($(div).hasClass("CatalogNumber")){
                    console.log($(div).find('.editField'))
                    $(div).html("<input class=\" form-control editField\" value=\""+$(div).text() +"\">");
                    $(div).children('.editField').mask('SSS-000000000000');
                    return;
                }

        text = $(div).text();
        $(div).html("<input class=\"form-control editField\"type=\"text\" value=\""+ text +"\">");
    })});
    $(".editSubmitButton").click(updated)
    $(document).mouseup(function(e){
            console.log(e.target)
            if (!$(e.target).hasClass("editField") &&!$(e.target).hasClass("editSubmitButton") &&
                    !$(e.target).parent().hasClass("editing") && !$(e.target).parent().parent().hasClass("editing")&&
                    !$(e.target).parent().parent().parent().parent().hasClass("editing")){
                loadTable();
                $(document).off("mouseup");
            }
        });
}
function updated(){
    if (validate()){

        var collectible = {};
        collectible.id = $(".name .editField").parent().parent().parent().attr('id');
        collectible.name = $(".name .editField").val().toLowerCase();
        collectible.age = $(".age .editField").val().toLowerCase();
        collectible.description = $(".description .editField").val().toLowerCase();
        collectible.category = $(".category .editField").val().toLowerCase();
        collectible.condition = $(".condition .editField").val().toLowerCase();
        collectible.colors = getColors();
        collectible.keywords = getKeywords();
        collectible.sold = $(".soldStatus :selected").text();
        collectible.catalogueNumber = $(".catalogNumber .editField").val().toUpperCase();
        collectible.sellDate = $(".sellDate .editField").val() === ""? null:moment(new Date($(".sellDate .editField").val())).format("MM/DD/YYYY");
        collectible.purchaseDate =  moment(new Date($(".purchaseDate .editField").val())).format("MM/DD/YYYY");

        $.ajax({
            url: '/collectible/'+collectible.id,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(collectible)
        }).then(function(){
            toast("Updated!",true);
            loadTable();
            $(document).off("mouseup");
        }, function(error){
            toast("Update Unsuccessful. Maybe the catalog number is is not Unique")
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
    var colors = getColors();
    var keywords = getKeywords();
    var sold = $(".soldStatus :selected").text();
    var catalogNumber = $(".catalogNumber .editField").val().toUpperCase();
    var purchaseDate = moment(new Date($(".purchaseDate .editField").val()));
    var sellDate = moment(new Date($(".sellDate .editField").val()));


    valid = isValid(name,".name",255) &&
    isValid(age,".age",255) &&
    isValid(category,".category",255) &&
    isValid(condition,".condition",255) &&
    isValid(catalogNumber,".catalogNumber",16) && (catalogNumber.length === 16 || toast("Catalog Number is not in a valid format")) &&
    isKeywordsValid(keywords) && isColorsValid(colors) &&
    isDatesValid();

    function isDatesValid(){
        if(!purchaseDate.isValid()){
             $(".purchaseDate .editField").addClass("error");
             toast("Purchase Date is invalid")
             return false;
        }
        if(sold === "false"){
            $(".sellDate .editField").val(null);
            return true;
        }
        if(!sellDate.isValid()){
             $(".sellDate .editField").addClass("error");
             toast("Sell Date is invalid")
             return false;
        }

        if(sellDate.isBefore(purchaseDate)){
            $(".sellDate .editField").addClass("error");
             toast("Sell Date cannot be before purchase date")
             return false;
        }
        return true;
    }

    function isValid(text,where,length){
        if(text == null || text == ""){
            $(where+" .editField").addClass("error");
            toast(where.replace('.','')+" cannot be null")
            return false;
        }
       if(/^[a-zA-Z0-9- ]*$/.test(text) == false) {
           $(".color .editField").addClass("error");
           toast("Colors cannot use special characters")
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

    function isColorsValid(colors){
            if(colors.length < 1 ){
                $(".color .editField").addClass("error");
                toast("Must have at least one color.")
                 return false;
            }

            for(var i =0; i < colors.length;i++){
                if(/^[a-zA-Z0-9- ]*$/.test(colors[i]) === false) {
                    $(".colors .editField").addClass("error");
                    toast("Colors cannot use special characters")
                    return false;
            }}


            if(hasDuplicates(colors))
            {
                $(".color .editField").addClass("error");
                toast("Cannot have the same color more than once.")
                 return false;
            }
             return true;
        }

    function isKeywordsValid(keywords){
        if(keywords.length < 3 ){
            $(".keywords .editField").addClass("error");
            toast("Must have at least three keywords")
            return false;
        }

        for(var i =0; i < keywords.length;i++){
            if(/^[a-zA-Z0-9- ]*$/.test(keywords[i]) === false) {
                $(".keywords .editField").addClass("error");
                toast("Keywords cannot use special characters")
                return false;
        }}
        if(hasDuplicates(keywords))
        {
            $(".keywords .editField").addClass("error");
            toast("Cannot have the same keyword more than once.")
            return false;
        }
         return true;
    }
    return valid;
}
function hasDuplicates(array) {
    return (new Set(array)).size !== array.length;
}
function getKeywords(){
    var keywords =  $(".keywords .editField").val().toLowerCase();
    keywords = keywords.replaceAll(' ',',');
    keywords = keywords.split(',');
    keywords = keywords.clean("");
    return keywords;
}
function getColors(){
    var colors =  $(".color .editField").val().toLowerCase();
    colors = colors.replaceAll(' ',',');
    colors = colors.split(',');
    colors = colors.clean("");
    return colors;
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