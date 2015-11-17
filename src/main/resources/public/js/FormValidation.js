$(document).ready(function(){
	$("#inputType").focusout(function(){
		validateType();
	});
	$("#inputColor").focusout(function(){
		validateColor();
	});
	$("#inputCondition").focusout(function(){
		validateCondition();
	});
	$("#inputAge").focusout(function(){
		validateAge();
	});
	$("#inputDescription").focusout(function(){
		validateDescription();
	});
	$("#inputName").focusout(function(){
		validateName();
	});
	$("#inputCatalogNumber").focusout(function(){
		validateCatalogNumber();
	});
	$("#inputKeywords").focusout(function(){
		validateKeywords();
	});
});

function validateType(){
	var text = $("#inputType").val();
	if (text == null || text == ""){
		$("#inputType").parent().parent().find(".errorText").css("visibility", "visible"); //Makes the error message visible
		$("#inputType").parent().parent().find(".errorText").text("Required field");
		$("#inputType").addClass("error");
	}else if(text.length > 255){
		$("#inputType").parent().parent().find(".errorText").css("visibility", "visible"); //Makes the error message visible
		$("#inputType").parent().parent().find(".errorText").text("Must be less than 256 characters");
		$("#inputType").addClass("error");
	}else {
		$("#inputType").removeClass("error");
		$("#inputType").parent().parent().find(".errorText").css("visibility", "hidden"); //Makes the error message invisible
	}
}

function validateColor(){
	var text = $("#inputColor").val();
	if (text == null || text == ""){
		$("#inputColor").parent().parent().find(".errorText").css("visibility", "visible");
		$("#inputColor").parent().parent().find(".errorText").text("Required field");
		$("#inputColor").addClass("error");
	}else if(text.length > 255){
		$("#inputColor").parent().parent().find(".errorText").css("visibility", "visible");
		$("#inputColor").parent().parent().find(".errorText").text("Must be less than 256 characters");
		$("#inputColor").addClass("error");
	}else {
		$("#inputColor").removeClass("error");
		$("#inputColor").parent().parent().find(".errorText").css("visibility", "hidden");
	}
}

function validateCondition(){

		var text = $("#inputCondition").val();
		if (text == null || text == ""){
			$("#inputCondition").parent().parent().find(".errorText").css("visibility", "visible");
			$("#inputCondition").parent().parent().find(".errorText").text("Required field");
			$("#inputCondition").addClass("error");
		}else if(text.length > 255){
            $("#inputCondition").parent().parent().find(".errorText").css("visibility", "visible");
            $("#inputCondition").parent().parent().find(".errorText").text("Must be less than 256 characters");
            $("#inputCondition").addClass("error");
		}else {
			$("#inputCondition").removeClass("error");
			$("#inputCondition").parent().parent().find(".errorText").css("visibility", "hidden");
		}

}

function validateAge(){
	var text = $("#inputAge").val();
	if (text == null || text == ""){
		$("#inputAge").parent().parent().find(".errorText").css("visibility", "visible");
		$("#inputAge").parent().parent().find(".errorText").text("Required field");
		$("#inputAge").addClass("error");
	}else if(text.length > 255){
        $("#inputAge").parent().parent().find(".errorText").css("visibility", "visible");
        $("#inputAge").parent().parent().find(".errorText").text("Must be less than 256 characters");
        $("#inputAge").addClass("error");
	}else {
		$("#inputAge").removeClass("error");
		$("#inputAge").parent().parent().find(".errorText").css("visibility", "hidden");

	}
}

function validateDescription(){
	var text = $("#inputDescription").val();
	if (text == null || text == "") {
		$("#inputDescription").parent().find(".errorText").css("visibility", "visible");
		$("#inputDescription").parent().find(".errorText").text("Required Field");
		$("#inputDescription").addClass("error");

	}else if(text.length > 1000){
		$("#inputDescription").parent().find(".errorText").css("visibility", "visible");
		$("#inputDescription").parent().find(".errorText").text("Must be 1000 characters or less");
		$("#inputDescription").addClass("error");
	}else {
		$("#inputDescription").removeClass("error");
		$("#inputDescription").parent().find(".errorText").css("visibility", "hidden");
	}
}

function validateName(){
	var text = $("#inputName").val();
	if (text == null || text == "") {
		$("#inputName").parent().find(".errorText").css("visibility", "visible");
		$("#inputName").parent().find(".errorText").text("Required Field");
		$("#inputName").addClass("error");
	}else if(text.length > 255){
		$("#inputName").parent().find(".errorText").css("visibility", "visible");
		$("#inputName").parent().find(".errorText").text("Must be less than 256 characters");
		$("#inputName").addClass("error");
	}else {
		$("#inputName").removeClass("error");
		$("#inputName").parent().find(".errorText").css("visibility","hidden");
	}
}

function validateCatalogNumber(){
	var text = $("#inputCatalogNumber").val();
	if (text == null || text == "") {
		$("#inputCatalogNumber").parent().find(".errorText").css("visibility", "visible");
		$("#inputCatalogNumber").parent().find(".errorText").text("Required field");
		$("#inputCatalogNumber").addClass("error");
	}else if(text.length != 16){
		$("#inputCatalogNumber").parent().find(".errorText").css("visibility", "visible");
		$("#inputCatalogNumber").parent().find(".errorText").text("Must follow the AAA-############ Format")
		$("#inputCatalogNumber").addClass("error");
	}else {
		$("#inputCatalogNumber").removeClass("error");
		$("#inputCatalogNumber").parent().find(".errorText").css("visibility","hidden");
	}
}

function validateKeywords(){
	var keyLength = $("#keywords").text().trim();
	if (keyLength.length > 1000){
		$("#inputKeywords").parent().find(".errorText").css('visibility','visible');
		$("#inputKeywords").parent().find(".errorText").text("Must be 1000 characters or less");
		$("#inputKeywords").addClass("error");
	}else if ($(".keyword").length < 3){
		$("#inputKeywords").parent().parent().parent().parent().find(".errorText").css('visibility','visible');
		$("#inputKeywords").parent().parent().parent().parent().find(".errorText").text("3 keywords minimum");
		$("#inputKeywords").addClass("error");
	}else {
		$("#inputKeywords").removeClass("error");
		$("#inputKeywords").parent().parent().parent().parent().find(".errorText").css('visibility','hidden');
	}
}