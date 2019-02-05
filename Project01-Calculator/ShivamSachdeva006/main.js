
var screen = document.getElementById('Diplay-screen');
function display(num){
    screen.value +=num; 
    }
function result(){
    screen.value =  eval(screen.value);
    }
function backSpace(){
    screen.value = screen.value.substring(0,screen.value.length - 1)
    }
function clearInput(){
    screen.value='';
}