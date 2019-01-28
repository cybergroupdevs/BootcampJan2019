
var input = document.getElementById('input'),
  number = document.querySelectorAll('.numbers'),
  operator = document.querySelectorAll('.op'),
  eq = document.getElementById('eq'),
  clear = document.getElementById('cl'),
  result = false;


function numberfunc(value){

  var currentString = input.value;
  // console.log(currentString);
  var lastChar = currentString[currentString.length - 1];


  if (result === false) {

    input.value += value;
    console.log(value)

  } else if (result == true && lastChar == "+" || lastChar == "-" || lastChar == "*" || lastChar == "÷") {

    result = false;
    input.value += value;

  } else {
    result = false;
    input.value = "";
    input.value += value;
  }

  }

function decimal(value){

    var currentString = input.value;
    // console.log(currentString);
    var lastChar = currentString[currentString.length - 1];

    if(lastChar == "+" || lastChar == "-" || lastChar == "*" || lastChar == "÷" || lastChar =="."){

    }
    else if (result === false) {
      console.log("case 1");
      input.value += value;
      console.log(value)
    } else {
  console.log("case 3");
      result = false;
      input.value = "";
      input.value += value;
    }

    }


function opfunc(value){
  var currentString = input.value;
  var lastChar = currentString[currentString.length - 1];

  if (lastChar === "+" || lastChar === "-" || lastChar === "*" || lastChar === "÷") {

    var newString = currentString.substring(0, currentString.length - 1) + value;
    input.value = newString;

  } else if (currentString.length == 0) {

      console.log("no numbers");

  } else {
      input.value += value;
  }


}

eq.addEventListener("click", function() {

  var inputString = input.value;
  input.value = eval(inputString);
  result = true;
});

clear.addEventListener("click", function() {
  input.value = "";
})
