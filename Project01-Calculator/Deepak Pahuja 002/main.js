var result = document.getElementById("result");
var btn = document.getElementById("button");

btn.addEventListener("click", func);


function func(e){
    return result.value += this.value; 
 };