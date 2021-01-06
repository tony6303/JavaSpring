var a = document.querySelector("#hide");

a.addEventListener("click",function(){
    var b = document.querySelector("p");
    b.remove();
});

$("#hide").click(function(){
    $("p").hide();
});
$("#show").click(function(){
    $("p").show();
});