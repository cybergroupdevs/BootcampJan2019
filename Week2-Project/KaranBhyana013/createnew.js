        var arr=[];
function createnew(){
    
      var Name= document.getElementById("name").value;
    var Email = document.getElementById("email").value ;
     var Age = document.getElementById("age").value ;
     var Gender = document.getElementById("gender").value ;
    //var Gender = e.options[e.selectedIndex].value
     var Phone = document.getElementById("Phone").value ;
    var DesignationID = document.getElementById("Designation").value ;
    console.log(Name , Email, Gender, Phone, DesignationID, Age );
    if(Age<18)
        {
            alert("Please enter valid age");
        }
    else{
   // || Email|| Age  || Gender || Phone|| DesignationID 
    if(Name !="" && Email !="" && Age!=""  && Gender!="" && Phone!="" ){
    var myOBJ = {
        Name,
        Email,
        Age,
        Gender,
        Phone,
        DesignationID     
    }
   $.ajax({
        type:'POST',
        url : 'http://localhost:62622/api/Employees',
        dataType:"JSON",
        data:myOBJ,
        success:function(res){
        alert("Entry has been created");
        window.location.href="home.html"
    }
    })
     }
    else
        {
        alert("Please enter all the values")
        }
    }
}
function ConfirmDelete()
    {
      var x = confirm("Are you sure you want to delete?");
      if (x)
          
          return deleteitem();
      else
        return false;
    }
        

function cancel() {
alert("No New Entry added");
  window.location.href='home.html';
}

function checkform()
{
    var f = document.forms["theform"].elements;
    var cansubmit = true;

    for (var i = 0; i < f.length; i++) {
        if (f[i].value.length == 0) cansubmit = false;
    }

    if (cansubmit) {
        document.getElementById('submitbutton').disabled = false;
    }
    else {
        document.getElementById('submitbutton').disabled = 'disabled';
    }
}

    //document.getElementById("hey").disabled = true;
$(document).ready(function(){
const Url1 = 'http://localhost:62622/api/Designations/';
    //console.log(Url);
    $.get(Url1, function(data, status){
         async: false;
           // console.log(data.length);
            
        var select = document.getElementById('Designation');
        for (var i = 0; i<data.length; i++){
            var opt = document.createElement('option');
            opt.value = data[i].Id;
            opt.innerHTML = data[i].Name;
            select.appendChild(opt);
        }
      
        })

});