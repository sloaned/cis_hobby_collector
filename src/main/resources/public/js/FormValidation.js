$(document).ready(function(){

    $("#inputType").focusout(function(){
        var text = $(this).val();
        if (text == null || text == ""){
            $(this).parent().parent().find(".errorText").remove();
            $(this).parent().parent().append("<p class='errorText'>Required field</p>");
            $(this).addClass("error");
        }else {
            $(this).removeClass("error");
            $(this).parent().parent().find(".errorText").remove();
        }
    });

    $("#inputColor").focusout(function(){
        var text = $(this).val();
        if (text == null || text == ""){
            $(this).parent().parent().find(".errorText").remove();
            $(this).parent().parent().append("<p class='errorText'>Required field</p>");
            $(this).addClass("error");
        }else {
            $(this).removeClass("error");
            $(this).parent().parent().find(".errorText").remove();
        }
    });

    $("#inputCondition").focusout(function(){
        var text = $(this).val();
        if (text == null || text == ""){
            $(this).parent().parent().find(".errorText").remove();
            $(this).parent().parent().append("<p class='errorText'>Required field</p>");
            $(this).addClass("error");
        }else {
            $(this).removeClass("error");
            $(this).parent().parent().find(".errorText").remove();
        }
    });

    $("#inputAge").focusout(function(){
        var text = $(this).val();
        if (text == null || text == ""){
            $(this).parent().parent().find(".errorText").remove();
            $(this).parent().parent().append("<p class='errorText'>Required field</p>");
            $(this).addClass("error");
        }else {
            $(this).removeClass("error");
            $(this).parent().parent().find(".errorText").remove();

        }
    });

    $("#inputDescription").focusout(function(){
        var text = $(this).val();
        if (text == null || text == "") {
            $(this).parent().find(".errorText").remove();
            $(this).parent().append("<p class='errorText'>Required field</p>");
            $(this).addClass("error");

        }else if(text.length >= 1000){
            $(this).parent().find(".errorText").remove();
            $(this).parent().append("<p class='errorText'>Must be less than 1000 characters</p>");
            $(this).addClass("error");
        }else {
            $(this).removeClass("error");
            $(this).parent().find(".errorText").remove();
        }
    });

    $("#inputName").focusout(function(){
        var text = $(this).val();
        if (text == null || text == "") {
            $(this).parent().find(".errorText").remove();
            $(this).parent().append("<p class='errorText'>Required field</p>");
            $(this).addClass("error");
        }else if(text.length >= 255){
            $(this).parent().find(".errorText").remove();
            $(this).parent().append("<p class='errorText'>Must be less than 255 characters</p>");
            $(this).addClass("error");
        }else {
            $(this).removeClass("error");
            $(this).parent().find(".errorText").remove();
        }
    });

	$("#inputCatalogNumber").focusout(function(){
		var text = $(this).val();
		if (text == null || text == "") {
			$(this).parent().find(".errorText").remove();
			$(this).parent().append("<p class='errorText'>Required field</p>");
			$(this).addClass("error");
		}else if(text.length != 16){
			$(this).parent().find(".errorText").remove();
			$(this).parent().append("<p class='errorText'>Must type in all characters</p>");
			$(this).addClass("error");
		}else {
			$(this).removeClass("error");
			$(this).parent().find(".errorText").remove();
		}
	});

	$("#inputKeywords").focusout(function(){
		var keyLength = $("#keywords").text().trim();
		if (keyLength.length >= 1000){
			$(this).parent().find(".errorText").remove();
			$(this).parent().append("<p class='errorText'>Exceeds 1000 character limit</p>");
			$(this).addClass("error");
		}else {
			$(this).removeClass("error");
			$(this).parent().find(".errorText").remove();
		}
	});

});