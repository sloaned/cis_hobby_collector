$(document).ready(function() {

	var form = $("#submitAdd");

		var bool = false;
		if (!numeric(form)) {
			bool = true;
		}
		if (!requiredSize(form) || bool) {
			bool = true;
		}
		if(!required(form) || bool) {

		}

});

function required (form) {
	var bool = true;
	form.find(".required").each(function (){
		var inputText = $(this).val();
		if (!inputText || inputText.replace(/\s/g, "").length === 0) {
			$(this).css("border-color", "red");
			if (!$(this).next().is(".requiredMessage")) {
				$(this).after("<span class=\"requiredMessage\" style=\"color: red; font-size: 8px\">This field is required.</span>");
			}
			bool = false;
		} else {
			$(this).css("border-color", "");
			if ($(this).next().is(".requiredMessage")) {
				$(this).next().remove();
			}
		}
		
	});
	return bool;
}

function numeric (form) {
	var bool = true;
	form.find(".numeric").each(function (){
		var inputNumber = $(this).val();
		if (inputNumber && (isNaN(inputNumber) || inputNumber[0] === " ")) {
			$(this).css("border-color", "red");
			if (!$(this).next().is(".numericMessage")) {
				$(this).after("<span class=\"numericMessage\" style=\"color: red; font-size: 8px\">Enter numbers only.</span>");
			}
			bool = false;
		} else {
			$(this).css("border-color", "");
			if ($(this).next().is(".numericMessage")) {
				$(this).next().remove();
			}
		}
	});
	return bool;
}

function requiredSize (form) {
	var bool = true;
	form.find(".requiredSize").each(function (){
		var input = $(this);
		var inputLength = input.val().length;
		var inputMaxLength = Number(input.attr("maxlength"));	//Convert to number because .attr returns a string
		if (inputLength !== inputMaxLength && input.val()) {
			$(this).css("border-color", "red");
			if (!$(this).next().is(".requiredSizeMessage")) {
				$(this).after("<span class=\"requiredSizeMessage\" style=\"color: red; font-size: 8px\">You need to enter " + inputMaxLength + " characters.</span>");
			}
			bool = false;
		} else {
			$(this).css("border-color", "");
			if ($(this).next().is(".requiredSizeMessage")) {
				$(this).next().remove();
			}
		}
	});
	return bool;
}
	
	

