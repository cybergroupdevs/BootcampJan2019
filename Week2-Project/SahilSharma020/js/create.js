$(document).ready(function(){
  console.log("hello");

  var designations = [];
  var submit = document.getElementById('submit_btn');

  var desig_select = document.getElementById('designation');

  $.ajax({url:"http://localhost:63099/api/designations",async:false,success: function(result){
    // console.log(result);
    // console.log(result[].name);
    for(var i=0;i<result.length;i++){
      designations.push({id: result[i].id,name: result[i].name});
    }
    // console.log(designations);
  }});

  // console.log(designations.length);

  for(var i=0;i<designations.length;i++){

    var option = document.createElement('option');
    var optext = document.createTextNode(designations[i].name);
    option.appendChild(optext);
    option.setAttribute('value',designations[i].id);
    desig_select.appendChild(option);
  }

  submit.addEventListener('click',function(event){
      event.preventDefault();
      console.log("submitted");


        var name = document.getElementById('user_name').value;
        var sex = document.getElementById('sex').value;
        var age = document.getElementById('age').value;
        var designationID = document.getElementById('designation').value;

        if(name && (age>18)){

            var send_data = {
                "Name": name,
                "Gender": sex,
                "age": age,
                "designationID": designationID,
            };

            var saveData = $.ajax({
              type: 'POST',
              url: "http://localhost:63099/api/employees",
              data: send_data,
              dataType: "json",
              success: function(result) {
                alert("Employee Created");
                window.location = "home.html";
              }
            });
            // saveData.error(function() { alert("Something went wrong"); });

          };



  });
});
