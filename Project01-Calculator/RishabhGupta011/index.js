var inpexp = document.getElementById('inp-exp');
function addToInput(txt)
{
    inpexp.value +=txt; 
}
function calc(){
    inpexp.value =  eval(inpexp.value);
}
function removeFromInput()
{
    inpexp.value = inpexp.value.substring(0,inpexp.value.length - 1)
}
function clearInput()
{
    inpexp.value='';
}
