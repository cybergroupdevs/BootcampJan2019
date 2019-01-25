// Initialize Firebase
var config = {
  apiKey: "AIzaSyD6vkSLmBDyDU2eZAUeEpXV-fWaOr_nDM0",
  authDomain: "cyber1.firebaseapp.com",
  databaseURL: "https://cyber1.firebaseio.com",
  projectId: "cyber1",
  storageBucket: "cyber1.appspot.com",
  messagingSenderId: "675887791659"
};
firebase.initializeApp(config);

var email = document.getElementById('email');
var password = document.getElementById('pass');

document.getElementById("signup").addEventListener("click", function(event){
  event.preventDefault();
  console.log("works");
  var email = this.email;
  var password = this.password;
  firebase.auth().createUserWithEmailAndPassword(email, password).catch(function(error) {
          // Handle Errors here.
          var errorCode = error.code;
          var errorMessage = error.message;
          // [START_EXCLUDE]
          if (errorCode == 'auth/weak-password') {
            alert('The password is too weak.');
          } else {
            alert(errorMessage);
          }
          console.log(error);
          // [END_EXCLUDE]
        });
        // [END createwithemail]
      });
