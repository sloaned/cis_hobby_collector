/**
 * Created by ddelaney on 11/4/2015.
 */
$(document).ready(function(){

    $("#addCollectibleButton").click(function(){
        $("#newCollectibleForm").css("display", "block");
        $("#fade").css("display", "block");
    });

    //Add categories to dropdown
    $.ajax({
        url: "/category",
        method: "GET"
    }).then(function(categories){
        addDropdown($("#typeDropdown").html(), $("#typeSelection"), categories)
        $("#typeSelection").find("li").click(function () {
            var text = $(this).text();
            console.log(text);
            $("#inputType").val(text);
        });
    });

    //Add color to dropdown
    $.ajax({
        url: "/color",
        method: "GET"
    }).then(function(colors){
        addDropdown($("#colorDropdown").html(), $("#colorSelection"), colors);
        $("#colorSelection").find("li").click(function () {
            var text = $(this).text();
            $("#inputColor").val(text);
        });
    });

    //Add conditions to dropdown
    $.ajax({
        url: "/conditions",
        method: "GET"
    }).then(function(conditions){
        addDropdown($("#conditionDropdown").html(), $("#conditionSelection"), conditions);
        $("#conditionSelection").find("li").click(function () {
            var text = $(this).text();
            $("#inputCondition").val(text);
        });
    });

    //Add age to dropdown
    $.ajax({
        url: "/agetypes",
        method: "GET"
    }).then(function(age){
        addDropdown($("#ageDropdown").html(), $("#ageSelection"), age);
        $("#ageSelection").find("li").click(function () {
            var text = $(this).text();
            $("#inputAge").val(text);
        });
    });

    // Removes popup from display when users clicks away from container.
    $(document).mouseup(function (e) {
        var container = $("#newCollectibleForm");

        if (!container.is(e.target)
            && container.has(e.target).length === 0)
        {
            $("#newCollectibleForm").css("display", "none");
            $("#fade").css("display", "none");
        }
    });

    $("#cancelAdd").click(function(){
        $("#newCollectibleForm").css("display", "none");
        $("#fade").css("display", "none");
    });

    $("#submitAdd").click(function(){
        var isValid = false
        if ($(".error").length < 1){
            isValid = true;
        }
        var color = {};
        color.color = $("#inputColor").val().toLowerCase();
        var age = {};
        age.age = $("#inputAge").val().toLowerCase();
        var category = {};
        category.category = $("#inputType").val().toLowerCase();
        var condition = {};
        condition.condition = $("#inputCondition").val().toLowerCase();

        var collectible = {};
        collectible.name = $("#inputName").val().toLowerCase();
        collectible.age = age;
        collectible.description = $("#inputDescription").val().toLowerCase();
        collectible.category = category;
        collectible.condition = condition;
        collectible.color = color;
        collectible.keywords = iCanHazKeywords();
        collectible.sold = $("#inputSoldstatus").find("button").text().toLowerCase().trim();
        collectible.catalogueNumber = $("#inputCatalogNumber").val();

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
        dynamic: true
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
            $(this).parent().before('<span class="keyword">'+ txt +'</span>');
        }
        $(this).val("");
    }).keyup(function(e){
        // if: comma,enter
        if(/(188|13)/.test(e.which)){
            $(this).focusout();
        }
    });

    $('#keywords').on('click','.keyword',function(){
        $(this).remove();
    });
}

function iCanHazKeywords(){
    var keywords = [];
    $(".keyword").each(function(){
        keywords.push({"keyword": $(this).text().toLowerCase()});
    });
    return keywords;
}