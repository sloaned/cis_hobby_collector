function update(){
    //if already changed td to input then don't do it again again
    if($(this).children().hasClass("editField"))return;
    //set self to the row of the CatalogNumber clicked
    self = $(this.parentNode);
    //console.log(self)

    //change all td to input boxes
    self.children().each(function(){
        text = $(this).text();
        $(this).html("<input class=\"editField\"type=\"text\" value=\""+ text +"\">");
    });
}