var result = document.getElementById("result");


function myfunc(val){
    result.value += val;
}

function e(){
    result.value = eval(result.value.toString());
}

