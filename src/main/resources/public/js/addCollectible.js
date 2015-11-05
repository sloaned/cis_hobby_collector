/**
 * Created by ddelaney on 11/4/2015.
 */
$(document).ready(function(){
    $("#addCollectibleButton").click(function(){
        $("#newCollectibleForm").css("display", "block");
        $("#fade").css("display", "block");
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
        var isValid = true; // Set to true for testing. TODO: Change to false for production.
        var collectible = {};

        if (isValid){
            $.ajax({
                url: '/collectibles',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(collectible)
            }).then(function(){
                console.log("Post successful")
            }, function(error){
                console.log(error);
            });
        }
    });

    $("#typeSelection").find("li").click(function () {
        var text = $(this).text();
        $("#inputType").val(text);
    });

    $("#colorSelection").find("li").click(function () {
        var text = $(this).text();
        $("#inputColor").val(text);
    });

    $("#conditionSelection").find("li").click(function () {
        var text = $(this).text();
        $("#inputCondition").val(text);
    });

    $("#ageSelection").find("li").click(function () {
        var text = $(this).text();
        $("#inputAge").val(text);
    });
});