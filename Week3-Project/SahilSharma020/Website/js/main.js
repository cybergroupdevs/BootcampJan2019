$(document).ready(function(){

  var tb = document.getElementById('tb')
  var table = document.getElementById('table');

  $.ajax({url: "http://localhost:8083/Employee/EmployeeAll", success: function(result){

      for(var i=0;i<result.length;i++){

        var name = result[i].name;
        var emp_id = result[i].id;
        var age = result[i].age;
        var designation = result[i].designationName;
        var data = [i+1,name,emp_id,age,designation];
        console.log(data);

        var row = document.createElement('tr');
        for(var j=0; j<5;j++){
          var cell = document.createElement('td');
          var cellText = document.createTextNode(data[j]);
          cell.appendChild(cellText);
          row.appendChild(cell);
        }
        var celld = document.createElement('td');

          //Creating Edit button
          var edit = document.createElement('i');
          edit.setAttribute('class','fas fa-pencil-alt edit');
          edit.setAttribute('style','font-size:24px');
          edit.setAttribute('value',emp_id);
          edit.setAttribute('onClick',"edit("+emp_id+")")
          celld.appendChild(edit);

          //creating del button
          var del = document.createElement('i');
          del.setAttribute('class','material-icons');
          del.setAttribute('style','font-size:24px');
          var deltext = document.createTextNode("delete");
          del.setAttribute('value',emp_id);
          del.appendChild(deltext);
          del.setAttribute('onClick',"del("+emp_id+")")
          celld.appendChild(del);




        row.appendChild(celld);

        table.appendChild(row);
        tb.classList.add("table-striped");
      }


        var trs = document.getElementsByTagName('tr');
        for(var i=1;i<trs.length;i++){
            // console.log(trs[i].cells.length);

            for(var j=2;j<3;j++){
              var tlink = trs[i].cells[j];
              tlink.addEventListener('click',function(value) {
                // console.log(trs[i]);

                console.log(value.srcElement.innerHTML);
                var id= value.srcElement.innerHTML;
                $.ajax({url:"http://localhost:8083/api/employees/"+id,success:function(result){
                  console.log(result);
                }});

              });
            }

        }
  }});


});
function edit(emp_id){
 console.log(emp_id);
 var url = "edit.html?id="+emp_id;
 window.location =url;

};

function del(emp_id){
    console.log(emp_id);
    var url = "http://localhost:8083/delete/Employee/"+emp_id;
    console.log(url);
    $.ajax({
      url:url,
      type: 'DELETE',
      success:function(result){
      alert("Deleted");
      location.reload();
    }});
  };
