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
		$("#inputDescription").addClass("error");

	}else if(text.length >= 1000){
		$("#inputDescription").parent().find(".errorText").css("visibility", "visible");
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
		$("#inputName").addClass("error");
	}else if(text.length >= 255){
		$("#inputName").parent().find(".errorText").css("visibility", "visible");
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
		$("#inputCatalogNumber").addClass("error");
	}else if(text.length != 16){
		$("#inputCatalogNumber").parent().find(".errorText").css("visibility", "visible");
		$("#inputCatalogNumber").addClass("error");
	}else {
		$("#inputCatalogNumber").removeClass("error");
		$("#inputCatalogNumber").parent().find(".errorText").css("visibility","hidden");
	}
}

function validateDate(String dateString){
	// First check for the pattern
    if(!/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(dateString))
        return false;

    // Parse the date parts to integers
    var parts = dateString.split("/");
    var day = parseInt(parts[1], 10);
    var month = parseInt(parts[0], 10);
    var year = parseInt(parts[2], 10);

    // Check the ranges of month
    if(month < 1 || month > 12)
        return false;

    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

    // Adjust for leap years
    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
        monthLength[1] = 29;

    // Check the range of the day
    return day > 0 && day <= monthLength[month - 1];
}

function validateKeywords(){
	var keyLength = $("#keywords").text().trim();
	if (keyLength.length >= 1000){
		$("#inputKeywords").parent().find(".errorText").css('visibility','visible');
		$("#inputKeywords").addClass("error");
	}else if ($(".keyword").length < 3){
		$("#inputKeywords").parent().parent().parent().parent().find(".errorText").css('visibility','visible');
		$("#inputKeywords").addClass("error");
	}else {
		$("#inputKeywords").removeClass("error");
		$("#inputKeywords").parent().parent().parent().parent().find(".errorText").css('visibility','hidden');
	}
}