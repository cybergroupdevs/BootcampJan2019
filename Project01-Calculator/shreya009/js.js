var s;
function op(val)
    {
        document.getElementById("d").value=val;
    }
    function num(val)
    {
        s=document.getElementById("d").value+=val;
    }
    function ans() 
    { 
        
        
     op(eval(document.getElementById("d").value)) 
    
        
    }
function clr() 
         { 
             document.getElementById("d").value="  "
         } 
function sq(s)
{
    
var x=Number(document.getElementById("d").value);
    document.getElementById("d").value=x*x;
}