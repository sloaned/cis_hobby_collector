/**
 * Created by ddelaney on 11/4/2015.
 */
$(document).ready(function(){

    $("#addCollectibleButton").click(function(){
        $("#newCollectibleForm").css("display", "block");
        $("#fade").css("display", "block");
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
            validateColor();
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
    $(document).mouseup(function (e) {
        var container = $("#newCollectibleForm");

        if (!container.is(e.target)
            && container.has(e.target).length === 0)
        {
            clearForm();
            closeForm();
        }
    });

    $("#cancelAdd").click(function(){
        clearForm();
        closeForm();
    });

    $("#submitAdd").click(function(){
        validateType();
        validateColor();
        validateCondition();
        validateAge();
        validateDescription();
        validateName();
        validateCatalogNumber();
        validateKeywords()

        var isValid = false;
        if ($(".error").length < 1){
            isValid = true;
        }
        var color = {};
        if (colorId == null){
            color.color = $("#inputColor").val().toLowerCase();
        }else{
            color.id = colorId;
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
        collectible.color = color;
        collectible.keywords = iCanHazKeywords();
        collectible.sold = $("#inputSoldStatus").find("button").text().toLowerCase().trim();
        collectible.catalogueNumber = $("#inputCatalogNumber").val();
        console.log(collectible);
        if (isValid){
            $.ajax({
                url: '/collectible',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(collectible)
            }).then(function(){
                console.log("Post successful")
                location.reload(true);
            }, function(error){
                console.log(error);
            });
        }
    });

    keywords();

    typeahead();

    $("#inputSoldStatus").find("li").click(function () {
        var text = $(this).text();
        $("#inputSoldStatus").find("button").html(text + " <span class=\"caret\"></span>");
    });

    $("#inputCatalogNumber").mask("SSS-000000000000");
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

function iCanHazKeywords(){
    var keywords = [];
    $(".keyword").each(function(){
        keywords.push({"keyword": $(this).contents().first().text().toLowerCase()});
    });
    return keywords;
}

function clearForm(){
        $("#inputType").val("");
        $("#inputColor").val("");
        $("#inputCondition").val("");
        $("#inputAge").val("");
        $("#inputDescription").val("");
        $("#inputName").val("");
        $("#inputCatalogNumber").val("");
        $("#inputKeywords").val("");
        $(".keyword").remove();
}

function closeForm(){
        $("#newCollectibleForm").css("display", "none");
        $("#fade").css("display", "none");
}