function update(){
    //if already changed td to input then don't do it again again
    if($(this).children().hasClass("editField"))return;
    //set row to the row of the CatalogNumber clicked
    row = $(this.parentNode);
    //console.log(self)

    //change all td to input boxes
    row.children().each(function(){
        //set this to what this is (the td)
        td=this;
        //if this the submit button we don't want to change it to a input field but we want to show it

        if($(td).children().hasClass("editSubmitButton")){
            $(td).children().toggleClass("hidden");
            return;
        }
        text = $(td).text();
        $(td).html("<input class=\"editField\"type=\"text\" value=\""+ text +"\">");
    });
    $(".editSubmitButton").click(updated)
}
function updated(){
    console.log("hi")
}