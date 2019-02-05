var digits = document.getElementById('screen');
function display(num){
    digits.value +=num; 
    }
function result(){
    digits.value =  eval(digits.value);
    }
function backSpace(){
    digits.value = digits.value.substring(0,digits.value.length - 1)
    }
function clearInput(){
    digits.value='';
    }