var result = document.getElementById("result");
var button = document.getElementsByClassName("button");

// var funcToButton = ['1','2']

// for (i = 0; i < 10; 1++){
//     button[i].addEventListener()
// }


function myfunc(val){
    result.value += val;
}

function e(){
    result.value = eval(result.value.toString());
}

