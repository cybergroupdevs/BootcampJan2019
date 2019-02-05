        var arr=[];
    
function ConfirmDelete()
    {
      var x = confirm("Are you sure you want to delete?");
      if (x)
          
          return deleteitem();
      else
        return false;
    }
        
function deleteitem(){ 
     var Id = localStorage.getItem("Id"); 
  var OBJ = {
       Id
  }
    $.ajax({
        type:'DELETE',
        url : 'http://localhost:62622/api/Employees/'+localStorage.getItem("Id"),
        dataType:"JSON",
        data: OBJ,
        success:function(res){
        alert("Entry has been deleted");
        window.location.href="home.html"
    }
    })

}
function cancel() {
  alert("No changes have been saved.");
    window.location.href="home.html";
}
function savechanges(){
    var Name= document.getElementById("name").value;
    var Id = localStorage.getItem("Id"); 
    var Email = document.getElementById("email").value ;
     var Age = document.getElementById("age").value ;
     var Gender = document.getElementById("gender").value ;
     var Phone = document.getElementById("Phone").value ;
    var DesignationID = document.getElementById("Designation").value ;
    console.log(Name, Id, Email);
    var myOBJ = {
        Id,
        Name,
        Email,
        Age,
        Gender,
        Phone,
        DesignationID     
    }
   $.ajax({
        type:'PUT',
        url : 'http://localhost:62622/api/Employees/'+localStorage.getItem("Id"),
        dataType:"JSON",
        data:myOBJ,
        success:function(res){
        alert("Entry has been updated");
        window.location.href="home.html"
    }
    })
    
            
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
    var arr=[];
    const Url = 'http://localhost:62622/api/Employees/'+localStorage.getItem("Id");
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
      
    $.get(Url, function(data, status){
         async: false;
           // console.log(data.Designation.Name);
        document.getElementById("name").value= data.Name;
        document.getElementById("email").value= data.Email;
        document.getElementById("age").value= data.Age;
        document.getElementById("Phone").value= data.Phone;
        document.getElementById("gender").value= data.Gender;
        console.log(data.Gender);
        document.getElementById("Designation").value=  data.Designation.Id;
        })
     
 document.getElementById("Id").value=localStorage.getItem("Id");

});