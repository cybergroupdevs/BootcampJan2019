$(document).ready(function(){
    $.ajax({
        
        type: 'GET',
        url: "http://localhost:50434/api/designations",
        dataType: "JSON",
        success: function(res){
//            console.log(res);
            
            var myselect = document.createElement('select');
            var mydropdown = document.getElementById('dropdown');
            myselect.setAttribute("id", "designation");
//            myselect.className = "designation";
            for(var i =0; i<res.length; i++){
                
//                console.log(res[i].id);
//                console.log(res[i]["name"]);
                var myoption = document.createElement('option');
                myoption.textContent = res[i]["name"];
                myoption.value = res[i].id;
                myselect.appendChild(myoption);
            
            }
            mydropdown.appendChild(myselect);     
    
       }
    });
    
    
}); 


function myfunc(){
    var fields = ["name","designation","mail"]; 


    for(var i =0;i<3;i++){
//        console.log(fields[i].value);
            var x = document.forms["myForm"][fields[i]].value;
            if (x == "") {
                alert("All fields are required");
                return false;
            }
    }


    var name = document.getElementById("name").value;
    var mail = document.getElementById("mail").value;
    var designationid = document.getElementById("designation").value;

    var myOBJ = {
        mail,
        name,
        designationid
    };

$.ajax({
    type: 'POST',
    url: "http://localhost:50434/api/employees/",
    dataType: "JSON",
    data :myOBJ,
    success: function(res){
//        console.log("sent");
//        console.log(res);
        alert("Cybergroup welcomes "+res.name);
        window.location.href = "DataList2.html";
    }
});

}


