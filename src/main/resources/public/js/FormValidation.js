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
		validateKeywords()
	});
});

function validateType(){
	var text = $("#inputType").val();
	if (text == null || text == ""){
		$("#inputType").parent().parent().find(".errorText").remove();
		$("#inputType").parent().parent().append("<p class='errorText'>Required field</p>");
		$("#inputType").addClass("error");
	}else {
		$("#inputType").removeClass("error");
		$("#inputType").parent().parent().find(".errorText").remove();
	}
}

function validateColor(){
	var text = $("#inputColor").val();
	if (text == null || text == ""){
		$("#inputColor").parent().parent().find(".errorText").remove();
		$("#inputColor").parent().parent().append("<p class='errorText'>Required field</p>");
		$("#inputColor").addClass("error");
	}else {
		$("#inputColor").removeClass("error");
		$("#inputColor").parent().parent().find(".errorText").remove();
	}
}

function validateCondition(){

		var text = $("#inputCondition").val();
		if (text == null || text == ""){
			$("#inputCondition").parent().parent().find(".errorText").remove();
			$("#inputCondition").parent().parent().append("<p class='errorText'>Required field</p>");
			$("#inputCondition").addClass("error");
		}else {
			$("#inputCondition").removeClass("error");
			$("#inputCondition").parent().parent().find(".errorText").remove();
		}

}

function validateAge(){
	var text = $("#inputAge").val();
	if (text == null || text == ""){
		$("#inputAge").parent().parent().find(".errorText").remove();
		$("#inputAge").parent().parent().append("<p class='errorText'>Required field</p>");
		$("#inputAge").addClass("error");
	}else {
		$("#inputAge").removeClass("error");
		$("#inputAge").parent().parent().find(".errorText").remove();

	}
}

function validateDescription(){
	var text = $("#inputDescription").val();
	if (text == null || text == "") {
		$("#inputDescription").parent().find(".errorText").remove();
		$("#inputDescription").parent().append("<p class='errorText'>Required field</p>");
		$("#inputDescription").addClass("error");

	}else if(text.length >= 1000){
		$("#inputDescription").parent().find(".errorText").remove();
		$("#inputDescription").parent().append("<p class='errorText'>Must be less than 1000 characters</p>");
		$("#inputDescription").addClass("error");
	}else {
		$("#inputDescription").removeClass("error");
		$("#inputDescription").parent().find(".errorText").remove();
	}
}

function validateName(){
	var text = $("#inputName").val();
	if (text == null || text == "") {
		$("#inputName").parent().find(".errorText").remove();
		$("#inputName").parent().append("<p class='errorText'>Required field</p>");
		$("#inputName").addClass("error");
	}else if(text.length >= 255){
		$("#inputName").parent().find(".errorText").remove();
		$("#inputName").parent().append("<p class='errorText'>Must be less than 255 characters</p>");
		$("#inputName").addClass("error");
	}else {
		$("#inputName").removeClass("error");
		$("#inputName").parent().find(".errorText").remove();
	}
}

function validateCatalogNumber(){
	var text = $("#inputCatalogNumber").val();
	if (text == null || text == "") {
		$("#inputCatalogNumber").parent().find(".errorText").remove();
		$("#inputCatalogNumber").parent().append("<p class='errorText'>Required field</p>");
		$("#inputCatalogNumber").addClass("error");
	}else if(text.length != 16){
		$("#inputCatalogNumber").parent().find(".errorText").remove();
		$("#inputCatalogNumber").parent().append("<p class='errorText'>Must type in all characters</p>");
		$("#inputCatalogNumber").addClass("error");
	}else {
		$("#inputCatalogNumber").removeClass("error");
		$("#inputCatalogNumber").parent().find(".errorText").remove();
	}
}

function validateKeywords(){
	var keyLength = $("#keywords").text().trim();
	if (keyLength.length >= 1000){
		$("#inputKeywords").parent().find(".errorText").remove();
		$("#inputKeywords").parent().append("<p class='errorText'>Exceeds 1000 character limit</p>");
		$("#inputKeywords").addClass("error");
	}else if ($(".keyword").length < 3){
		$("#inputKeywords").parent().find(".errorText").remove();
		$("#inputKeywords").parent().append("<p class='errorText'>Must have at least 3 keywords</p>");
		$("#inputKeywords").addClass("error");
	}else {
		$("#inputKeywords").removeClass("error");
		$("#inputKeywords").parent().find(".errorText").remove();
	}
}