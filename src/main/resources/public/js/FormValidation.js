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
	$("#inputPurchaseDate").focusout(function(){
		validatePurchaseDate();
	});
	$("#inputSellDate").focusout(function(){
		if($("#inputSoldStatus").find("button").text().trim() === "True" || $("#inputSellDate").val() != "")
		{
			validateSellDate();
		}
	});
	$("#soldStatusFalse").click(function(){	
		$("#inputSellDate").val("");
		$("#inputSellDate").removeClass("error");
		$("#inputSellDate").parent().find(".errorText").css("visibility","hidden");
		
	})
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
	if (text === null || text === "") {
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

function validatePurchaseDate(){
	var pDate = $("#inputPurchaseDate").val();
	if(!validateDate(pDate))
	{
		$("#inputPurchaseDateError").empty();
		$("#inputPurchaseDateError").append("Valid Date Required");
		$("#inputPurchaseDate").parent().find(".errorText").css("visibility", "visible");
		$("#inputPurchaseDate").addClass("error");
	}
	else if(!comparePurchaseDateToSellDate())
	{
		$("#inputPurchaseDateError").empty();
		$("#inputPurchaseDateError").append("Purchase date must be earlier than sell date");
		$("#inputPurchaseDate").parent().find(".errorText").css("visibility", "visible");
		$("#inputPurchaseDate").addClass("error");
	}
	else
	{
		$("#inputPurchaseDate").removeClass("error");
		$("#inputPurchaseDate").parent().find(".errorText").css("visibility","hidden");
		if($("#inputSellDateError").text() === "Sell date must come after purchase date")
		{
			$("#inputSellDate").removeClass("error");
			$("#inputSellDate").parent().find(".errorText").css("visibility","hidden");
		}
		
	}
}

function validateSellDate(){
	var sDate = $("#inputSellDate").val();
	
	if(!validateDate(sDate) && $("#inputSoldStatus").find("button").text().trim() === "True")
	{
		$("#inputSellDateError").empty();
		$("#inputSellDateError").append("Valid Date Required");
		$("#inputSellDate").parent().find(".errorText").css("visibility", "visible");
		$("#inputSellDate").addClass("error");
		return;
	}
	else if(!validateDate(sDate))
	{
		return;
	}
	else
	{
		$("#inputSellDate").removeClass("error");
		$("#inputSellDate").parent().find(".errorText").css("visibility","hidden");
		$("#inputSoldStatus").find("button").html("True<span class='caret'></span>");
	}
	
	if(!comparePurchaseDateToSellDate())
	{
		$("#inputSellDateError").empty();
		$("#inputSellDateError").append("Sell date must come after purchase date");
		$("#inputSellDate").parent().find(".errorText").css("visibility", "visible");
		$("#inputSellDate").addClass("error");
	}
	else
	{
		$("#inputSellDate").removeClass("error");
		$("#inputSellDate").parent().find(".errorText").css("visibility","hidden");
		if($("#inputPurchaseDateError").text() == "Purchase date must be earlier than sell date")
		{
			$("#inputPurchaseDate").removeClass("error");
			$("#inputPurchaseDate").parent().find(".errorText").css("visibility","hidden");
		}
		$("#inputSoldStatus").find("button").html("True <span class='caret'></span>");
	}
}

function comparePurchaseDateToSellDate(){
	var pDate = $("#inputPurchaseDate").val();
	var sDate = $("#inputSellDate").val();
	if(!validateDate(pDate) || !validateDate(sDate))
	{
		return true;
	}
	
	var pParts = pDate.split("/");
    var pDay = parseInt(pParts[1], 10);
    var pMonth = parseInt(pParts[0], 10);
    var pYear = parseInt(pParts[2], 10);
	var sParts = sDate.split("/");
    var sDay = parseInt(sParts[1], 10);
    var sMonth = parseInt(sParts[0], 10);
    var sYear = parseInt(sParts[2], 10);
	
    if(pYear > sYear)
    {
    	return false;
    }
    else if(pYear < sYear)
    {
    	return true;
    }
    
    if(pMonth > sMonth)
    {
    	return false;
    }
    else if(pMonth < sMonth)
    {
    	return true;
    }
    
    if(pDay > sDay)
    {
    	return false;
    }
    return true;
}

function validateDate(dateString){
	if(dateString === null || dateString === "")
	{
		return false;
	}
	// First check for the pattern
    if(!/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(dateString))
    {
        return false;
    }
    // Parse the date parts to integers
    var parts = dateString.split("/");
    var day = parseInt(parts[1], 10);
    var month = parseInt(parts[0], 10);
    var year = parseInt(parts[2], 10);

    // Check the ranges of month
    if(month < 1 || month > 12)
    {
    	return false;
    }
        
    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

    // Adjust for leap years
    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
    {
    	monthLength[1] = 29;
    }
        
    // Check the range of the day
    return day > 0 && day <= monthLength[month - 1];
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

    var keywords = [];
    $(".keyword").each(function() {
        keywords.push($(this).text());
    });
    if (hasDuplicates(keywords)) {
        $("#inputKeywords").parent().parent().parent().parent().find(".errorText").css('visibility','visible');
        $("#inputKeywords").parent().parent().parent().parent().find(".errorText").text("Duplicate keywords not allowed");
        $("#inputKeywords").addClass("error");
    } else {
        $("#inputKeywords").removeClass("error");
        $("#inputKeywords").parent().parent().parent().parent().find(".errorText").css('visibility','hidden');
    }
}

function hasDuplicates(array) {
    var valuesSoFar = Object.create(null);
    for (var i = 0; i < array.length; ++i) {
        var value = array[i];
        if (value in valuesSoFar) {
            return true;
        }
        valuesSoFar[value] = true;
    }
    return false;
}