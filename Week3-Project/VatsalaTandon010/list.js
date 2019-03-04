var url = "";
$(document).ready(function(){
    $.ajax({
        type: 'GET',
        url: "http://localhost:51589/api/Employees",
        dataType: "JSON",
        success: function(res){
            console.log("start");
            console.log(res);
            console.log("end");
        var body = document.getElementById('centre');
       showtable(res);
        function showtable(jsonObj) {

            var table = document.createElement('table');
            var tr = document.createElement('tr');
            
            var th1 = document.createElement('th');
            var th2 = document.createElement('th');
            var th3 = document.createElement('th');
            var th4 = document.createElement('th');
            var th5 = document.createElement('th');
            var th6 = document.createElement('th');
            

            th1.textContent = "Employee_CGI_Code";
            th2.textContent = "First_Name";
            th3.textContent = "Last_Name";
            th4.textContent = "Designation"; 
            th5.textContent = "Years_Of_Experiance";
            th6.textContent = "Qualification";
            
            
            tr.appendChild(th1);
            tr.appendChild(th2);
            tr.appendChild(th3);
            tr.appendChild(th4);
            tr.appendChild(th5);
            tr.appendChild(th6);
            
            
            table.appendChild(tr);
            var employeeIds = [];
            for (var i = 0; i < jsonObj.length; i++) {
                var tr = document.createElement('tr');
                var td1 = document.createElement('td');
                var td2 = document.createElement('td');
                var td3 = document.createElement('td');
                var td4 = document.createElement('td');
                var td5 = document.createElement('td');
                var td6 = document.createElement('td');
               
            
                td1.textContent = jsonObj[i].Employee_CGI_Code;
                td2.textContent = jsonObj[i].First_Name;
                td3.textContent = jsonObj[i].Last_Name;
                td4.textContent = jsonObj[i].Designation;
                td5.textContent = jsonObj[i].Years_Of_Experiance;
                td6.textContent = jsonObj[i].Qualification;
                
                td1.setAttribute("id", td1.innerHTML);                
                
               // localStorage.setItem("lastEmployee", JSON.stringify(jsonObj[i]));
                console.log(td1.innerHTML);
//                localStorage.setItem("key",td1.innerHTML);
//                url = "retrieve.html?id="+td1.innerHTML;
                td1.setAttribute("onclick","click1(this.id)" );
                
                

                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                tr.appendChild(td6);
                table.appendChild(tr);
                }
                body.appendChild(table);
        }
        }
    
    });
    
});


    function click1(clickid){
        
        console.log("here");
        console.log(clickid);
      localStorage.setItem("key",clickid);
        url = "retrieve.html?id="+clickid;
        window.location = url;
                    
                };