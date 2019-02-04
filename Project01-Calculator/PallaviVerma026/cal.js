
var digits = document.getElementById('screen');


function result()
{
    digits.value =  eval(digits.value);
 }



function display(num)
{
    digits.value +=num; 
 }

function clearInput()
{
    digits.value='';
}

