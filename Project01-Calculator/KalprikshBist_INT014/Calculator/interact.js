var display = document.getElementById("data");
function digit(a)
    {
        var myVar = a.innerHTML;
        console.log(myVar);
             if (myVar == '=') {
                 display.innerHTML = eval(display.innerHTML);
             } else if (myVar == 'C') {
                 display.innerHTML = 0;
             } else if (display.innerHTML == '0') {
                 display.innerHTML = myVar;
             } else {
                 display.innerHTML += myVar;
             }

    }
