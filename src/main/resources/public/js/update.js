function update(){
//set self to the row of the CatalogNumber clicked
    self = $(this.parentNode);
    //console.log(self)
    //change all td to input boxes
    self.children().each(function(td){
        text = $(this).text();
        $(this).html("<input class=\"input\"type=\"text\" value=\""+ text +"\">")
    });
}