

function postingdetails(){

  var firstname=document.getElementById('fname').value;
  var lastname=document.getElementById('lname').value;
  var phoneno=document.getElementById('phone').value;
  var emailid=document.getElementById('email').value;
  console.log(emailid);
  var password=document.getElementById('password').value;
  var PostingData={
            "Firstname": firstname,
            "Lastname": lastname,
            "Phone no":phoneno,
            "Email":emailid,
            "password":password



  }
    $.ajax({
        type: 'POST',
        url: 'http://localhost:64490/api/Employees',
        data:PostingData,  
            success: function(data) {
        alert("SUBMISSION SUCCESSFUL:WELCOME ABOARD");
        location.href = "employeelist.html";
      }
    });
  }
    
function deleteDetails(){
  

var idgetting=localStorage.getItem("id");
//"id"=idgetting;

if(confirm("ARE YOU SURE?")){
    $.ajax({
    url: 'http://localhost:64490/api/Employees/' + idgetting,
    type: 'DELETE',
    // data:DeletingSingleData,
    

    success: function(data) {
        alert("DATA DELETED SUCCESSFULLY");
        location.href = "employeelist.html";
    }
  
});}
    else{
      alert("im upset");
    }
}

function updatingdetails(){

  var firstname=document.getElementById('fname').value;
  var lastname=document.getElementById('lname').value;
 
  var emailid=document.getElementById('email').value;
  console.log(emailid);
  var password=document.getElementById('password').value;
  var UpdateData={
            "Firstname": firstname,
            "Lastname": lastname,
            "Email":emailid,
            "password":password,
            "id":idgetting 


  }


    $.ajax({
    url: 'http://localhost:64490/api/Employees/'+idgetting,
    type: 'PUT',
    data:UpdateData,
    success: function(data) {
        alert("UPDATED SUCCESSFULLY");
        location.href = "employeelist.html";
    }
});
 }