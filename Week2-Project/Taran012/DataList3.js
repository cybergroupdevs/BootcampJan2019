
var gid = 0;
$(document).ready(function(){
    
    $("#pop2").hide();
    $.ajax({
        
        type: 'GET',
        url: "http://localhost:50434/api/employees",
        dataType: "JSON",
        success: function(res){ 
    
            var body = document.getElementById('pop');
            showtable(res);
            
            function showtable(jsonObj) {

                var col = [];
                    for (var i = 0; i < jsonObj.length; i++) {
                        for (var key in jsonObj[i]) {
                            if (col.indexOf(key) === -1 && key!="designationid" ) {
                                col.push(key);
                            }
                        }
                    }
                col.push("");
                console.log("col");
                console.log(col);
                
                
                var table = document.createElement("table");
                var tr = table.insertRow(-1);                   // TABLE ROW.

                for (var i = 0; i < col.length; i++) {
                    var th = document.createElement("th");      // TABLE HEADER.
                    th.innerHTML = col[i];
                    tr.appendChild(th);
                }
                for (var i = 0; i < jsonObj.length; i++) {

                    tr = table.insertRow(-1);

                    for (var j = 0; j < (col.length - 1) ; j++) {
                        var tabCell = tr.insertCell(-1);
                        tabCell.innerHTML = jsonObj[i][col[j]];
                    }

                    var tabCell = tr.insertCell(-1);
//                    var tr = document.createElement("tr");
//                    var td = document.createElement("td");

                    var myImage1 = new Image(20, );
                    myImage1.src = 'edit.png';
                    var myImage2 = new Image(20, );
                    myImage2.src = 'delete.png';
                    myImage1.setAttribute("id", jsonObj[i].id);
                    myImage1.setAttribute("onclick","myfuncedit(this.id)");
                    myImage2.setAttribute("id", "del" + jsonObj[i].id)
                    myImage2.setAttribute("onclick","myfuncdel(this.id)");

                    tabCell.appendChild(myImage1);
                    tabCell.appendChild(myImage2);
                    tr.appendChild(tabCell);
                }
                var pop = document.getElementById("pop");
                pop.appendChild(table);
            }   


            }
        
        });
    });

function myfuncdel(imageID){       // function to delete data
//    console.log("here");
    delid = imageID.slice(3,);
//    console.log(delid);
    
    $.ajax({
        
        type: 'DELETE',
        url: "http://localhost:50434/api/employees/" + delid,
        dataType: "JSON",
        success: function(res){
//            console.log("deleted");
            document.location.reload();

        }
});
}


function myfuncedit(imageID){               // function to edit data
 
    $.ajax({                        // for dropdown
        async: false,
        type: 'GET',
        url: "http://localhost:50434/api/designations",
        dataType: "JSON",
        success: function(res){
            
            var myselect = document.createElement('select');
            var mydropdown = document.getElementById('dropdown');
            myselect.setAttribute("id", "designation");
            
            for(var i =0; i<res.length; i++){
                
                var myoption = document.createElement('option');
                myoption.textContent = res[i]["name"];
                myoption.value = res[i].id;
                myselect.appendChild(myoption);
            
            }
            mydropdown.appendChild(myselect);     
            
       }
});
      
    
    $.ajax({
        async: false,
        type: 'GET',
        url: "http://localhost:50434/api/employees/" + imageID,
        dataType: "JSON",
        success: function(res){
                        
            $("#pop2").show();
            
            document.getElementById("code2").innerHTML =  res.id;
            gid = res.id;
            document.getElementById("name2").setAttribute("value", res.name);
            document.getElementById("mail2").setAttribute("value", res.mail);
            document.getElementById("designation").value = res.designation["id"];
        }
});
}

function updatemethod(){
    id = gid;
    name = document.getElementById("name2").value;
    mail = document.getElementById("mail2").value;
    designationid = document.getElementById("designation").value;
    var myOBJ2 = {id, name, mail, designationid};
    console.log(myOBJ2);
    
    $.ajax({
        type: 'PUT',
        url: "http://localhost:50434/api/employees/"+ gid,
        dataType: "JSON",
        data :myOBJ2,
        success: function(res){
            document.location.reload();
       }
        
    });
}


