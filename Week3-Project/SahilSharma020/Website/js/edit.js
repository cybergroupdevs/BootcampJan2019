$(document).ready(function(){
  let params = (new URL(document.location)).searchParams;
  let emp_id = params.get("id");
  // console.log(emp_id);
  var in_result = {};

  $.ajax({url:"http://localhost:8083/Employee/"+emp_id,success:function(result){
    console.log(result);
      in_result = result;
      // console.log(in_result);
      // console.log(in_result.name);
      var name = in_result.name;
      var age = result.age;
      var desig = result.designation.name;
      var sex = result.Gender;


      // console.log(name,sex,age,desig);

      var user_field = document.getElementById('user_name');
      var sex_field = document.getElementById('sex');
      var age_field = document.getElementById('age');
      var desig_field = document.getElementById('designation');

      user_field.value = name;
      sex_field.value = sex;
      age_field.value = age;
      desig_field.value = desig;

  }});

  var submit = document.getElementById('submit_btn');

  submit.addEventListener('click',function(event){
      event.preventDefault();
      // console.log(in_result);
      console.log("submitted");
      var id = this.emp_id;
      // console.log(id);
      //Getting values

        var name = document.getElementById('user_name').value;
        var sex = document.getElementById('sex').value;
        var age = document.getElementById('age').value;
        var desig = document.getElementById('designation').value;
        // console.log(typeof(desig));
        var designationID = 2;
        if(desig == 'employee'){
          designationID = 1;
        }
        else {
          designationID = 2;
        }

        if(name && (age>18)){

        //   console.log("name ="+ name);
        // console.log("sex =" + sex);
        // console.log("age =" + age);
        // console.log("desig =" + designationID);
        var send_data = in_result;
        send_data.Name = name;
        send_data.Gender = sex;
        send_data.age = age;
        send_data.designationID = designationID;
              // var send_data = {
              //     "Name": name,
              //     "Gender": sex,
              //     "age": age,
              //     "designationID": designationID,
              // };
            var url = "http://localhost:8083/update/Employee/"+emp_id;
            // console.log(url);
            var saveData = $.ajax({
              type: 'PUT',
              url: url,
              data: send_data,
              dataType: "json",
              success: function(result) {
                alert("Employee Created");
                window.location = "home.html";
              }
            });
          };



  });


});
