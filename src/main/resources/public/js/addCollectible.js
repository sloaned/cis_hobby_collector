$(document).ready(function(){

    $("#addCollectibleButton").click(function(){
        $("#newCollectibleForm").css("display", "block");
        $("#fade").css("display", "block");
        $(document).mouseup(closeAdd);
    });

    //Add categories to dropdown
    var typeId = null;
    $.ajax({
        url: "/category",
        method: "GET"
    }).then(function(categories){
        addDropdown($("#typeDropdown").html(), $("#typeSelection"), categories)
        $("#typeSelection").find("li").click(function () {
            var text = $(this).text();
            $("#inputType").val(text);
            validateType();
            for (var i = 0; i < categories.length; i++){
                if (text == categories[i].category){
                    typeId = categories[i].id;
                }
            }
        });
    });

    //Add color to dropdown
    var colorId = null;
    $.ajax({
        url: "/color",
        method: "GET"
    }).then(function(colors){
        addDropdown($("#colorDropdown").html(), $("#colorSelection"), colors);
        $("#colorSelection").find("li").click(function () {
            var text = $(this).text();
            $("#inputColor").val(text);
            addColor();
            validateColors();
            for (var i = 0; i < colors.length; i++){
                if (text == colors[i].color){
                    colorId = colors[i].id;
                }
            }
        });
    });

    //Add conditions to dropdown
    var conditionId = null;
    $.ajax({
        url: "/conditions",
        method: "GET"
    }).then(function(conditions){
        addDropdown($("#conditionDropdown").html(), $("#conditionSelection"), conditions);
        $("#conditionSelection").find("li").click(function () {
            var text = $(this).text();
            $("#inputCondition").val(text);
            validateCondition();
            for (var i = 0; i < conditions.length; i++){
                if (text == conditions[i].condition){
                    conditionId = conditions[i].id;
                }
            }
        });
    });

    //Add era to dropdown
    var ageId = null;
    $.ajax({
        url: "/agetypes",
        method: "GET"
    }).then(function(age){
        addDropdown($("#ageDropdown").html(), $("#ageSelection"), age);
        $("#ageSelection").find("li").click(function () {
            var text = $(this).text();
            $("#inputAge").val(text);
            validateAge();
            for (var i = 0; i < age.length; i++){
                if (text == age[i].age){
                    ageId = age[i].id;
                }
            }
        });
    });

    // Removes popup from display when users clicks away from container.
    function closeAdd(e) {
        //if form isn't open don't bother checking anything.
        if ($("#newCollectibleForm").css("display") === "none")
            return;
        var container = $("#newCollectibleForm");

        if (!container.is(e.target)
            && container.has(e.target).length === 0)
        {
            console.log("Closing...");
            //if we click on the toast don't close the form
            if ($(e.target).attr("class").indexOf("toast") !== -1)
                return;

            clearForm();
            closeForm();
            $(document).off("mouseup");
        }
    }

    $("#cancelAdd").click(function(){
        clearForm();
        closeForm();
    });

    $("#submitAdd").click(function(){
        validateType();
        validateColors();
        validateCondition();
        validateAge();
        validateDescription();
        validateName();
        validateCatalogNumber();
        validateKeywords();
        validatePurchaseDate();
        if($("#inputSoldStatus").val() === "True")
        {
        	validateSoldDate();
        }


        var isValid = false;
        if ($(".error").length < 1){
            isValid = true;
        }
        var age = {};
        if (ageId == null){
            age.age = $("#inputAge").val().toLowerCase();
        }else{
            age.id = ageId;
        }
        var category = {};
        if (typeId == null){
            category.category = $("#inputType").val().toLowerCase();
        }else {
            category.id = typeId;
        }
        var condition = {};
        if (conditionId == null){
            condition.condition = $("#inputCondition").val().toLowerCase();
        }else{
            condition.id = conditionId;
        }

        var collectible = {};
        collectible.name = $("#inputName").val().toLowerCase();
        collectible.age = age;
        collectible.description = $("#inputDescription").val().toLowerCase();
        collectible.category = category;
        collectible.condition = condition;
        collectible.colors = iCanHazColorz();
        collectible.keywords = iCanHazKeywords();
        collectible.sold = $("#inputSoldStatus").find("button").text().toLowerCase().trim();
        collectible.catalogueNumber = $("#inputCatalogNumber").val();
        collectible.purchaseDate = $("#inputPurchaseDate").val();
        if(collectible.sold === "true")
        {
        	collectible.sellDate = $("#inputSellDate").val();
        }
        else
        {
        	collectible.sellDate = null;
        }
        console.log(collectible);
        if (isValid){
            $.ajax({
                url: '/collectible',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(collectible)
            }).then(function(){
                console.log("Post successful")
                toast("Collectible added", true);
                loadTable();
                clearForm();
                closeForm();
            }, function(error){
                console.log(error);
                toast("Catalog number already exists");
            });
        } else {
            toast(getErrors());
        }
    });

    keywords();
    colors();
    typeahead();

    $("#inputSoldStatus").find("li").click(function () {
        var text = $(this).text();
        $("#inputSoldStatus").find("button").html(text + " <span class=\"caret\"></span>");
    });

    $("#inputCatalogNumber").mask("SSS-000000000000");
    $("#inputPurchaseDate").mask("00/00/0000");
    $("#inputSellDate").mask("00/00/0000");
});

function typeahead(){
    var keywords = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.obj.whitespace('keyword'),
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        prefetch: '/keywords',
        remote: {
            url: '/keywords/%QUERY',
            wildcard: '%QUERY'
        }
    });

    $('#remote .typeahead').typeahead({
        hint: true,
        dynamic: false
    }, {
        name: 'keywords',
        display: 'keyword',
        source: keywords
    }).on('typeahead:close', function (obj, datum, name) {
        $(this).val("");
    });
}

function addDropdown (source, destination, object){
    var template = Handlebars.compile(source);
    destination.html(template(object));
}

function keywords () {
    $("#keywords input").focusout(function(){
        var txt= this.value.replace(/[^\w]/g,'');
        if(txt) {
            $(this).parent().before('<span class="keyword">'+ txt + '<span class="delete">X</span></span>');
        }
        $(this).val("");
    }).keyup(function(e){
        // if: comma,enter
        if(/(188|13)/.test(e.which)){
            $(this).focusout();
        }
    });

    $('#keywords').on('click','.delete',function(){
        $(this).parent().remove();
        validateKeywords();
    });
}

function colors() {
    $("#colors input").focusout(addColor).keyup(function(e){
        // if: comma,enter
        if(/(188|13)/.test(e.which)){
            $(this).focusout();
        }
    });

    $('#colors').on('click','.delete',function(){
        $(this).parent().remove();
        validateColors();
    });
}

function addColor(){
    var txt= $("#inputColor").val().replace(/[^\w]/g,'');
    if(txt) {
        $("#inputColor").parent().before('<span class="color">'+ txt + '<span class="delete">X</span></span>');
    }
    $("#inputColor").val("");
}

function iCanHazKeywords(){
    var keywords = [];
    $(".keyword").each(function(){
        keywords.push({"keyword": $(this).contents().first().text().toLowerCase()});
    });
    return keywords;
}

function iCanHazColorz(){
    var colors = [];
    $(".color").each(function(){
        colors.push({"color": $(this).contents().first().text().toLowerCase()});
    });
    return colors;
}

function clearForm(){
        $("#inputType").val("");
        $("#inputColor").val("");
        $(".color").remove();
        $("#inputCondition").val("");
        $("#inputAge").val("");
        $("#inputDescription").val("");
        $("#inputName").val("");
        $("#inputCatalogNumber").val("");
        $("#inputKeywords").val("");
        $("#inputPurchaseDate").val("");
        $("#inputSellDate").val("");
        $("#inputSoldStatus").find("button").html("False <span class='caret'></span>");
        $(".keyword").remove();
        $(".error").removeClass("error");
        $(".errorText").css("visibility", "hidden");
        $("body, #newCollectibleForm").scrollTop(0);
        $("#colors").css("border-color","#ccc");
}

function closeForm(){
        $("#newCollectibleForm").css("display", "none");
        $("#fade").css("display", "none");
}

function toast(message, successful) {
    toastr.options = {
        "positionClass": "toast-top-center",
        "preventDuplicates": true
    }

    var status;
    status = successful ? "Success" : "Error";

    toastr[status.toLowerCase()](message, status);

}

function getErrors() {
    var errText = "The following fields have errors: <br />";
    var hasError = false;
    $(".inputBox, #colors").each(function() {
        if ($(this).hasClass("error")) {
            errText += !$(this).is("#colors") ? $(this).attr("Placeholder") + "<br />" : "Colors <br />"
            hasError = true;
            console.log(errText);
        }

    });

    if ($("#inputCatalogNumber").hasClass("error")) {
        errText += "Catalog number <br />";
        hasError = true;
    }
    if ($("#inputKeywords").hasClass("error")) {
        errText += "Keywords <br />"
    }
    if ($("#inputPurchaseDate").hasClass("error")) {
        errText += "Purchase date <br />"
    }
    if ($("#inputSellDate").hasClass("error")) {
        errText += "Sell date"
    }

    return errText;
}