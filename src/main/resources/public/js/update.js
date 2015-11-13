function update(){
    //if already changed td to input then don't do it again again
    if($(this).children().hasClass("editField"))return;
    //set row to the row of the CatalogNumber clicked
    row = $(this.parentNode);
    //console.log(self)

    //change all td to input boxes
    row.children().each(function(){
        //if this the submit button we don't want to change it to a input field but we want to show it
        if($(this).children().hasClass("editSubmitButton")){
            $(this).children().toggleClass("hidden");
            return;
        }

        text = $(this).text();
        $(this).html("<input class=\"editField\"type=\"text\" value=\""+ text +"\">");
    });
}