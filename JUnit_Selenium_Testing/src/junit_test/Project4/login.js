var checker = "";


isLogged();

function isLogged(){
  var sen = localStorage.getItem("login");
  var sen2 = sen+"logged";

  if(localStorage.getItem(sen2) == 1){
    window.location.href = "front.html";
  }
}



function submitForm(){
    var email = document.getElementById("email1").value;
    var password = document.getElementById("password1").value;
    var label = document.getElementById("login-error").value;
    var passcheck =  localStorage.getItem(email);
    console.log(passcheck);
    if (email == "" || email.trim() == '' || password== "")
    {
        document.getElementById("login-error").innerHTML = "Email or password cannot be empty";
    }
    else if(!validateEmail(email))
    {
        document.getElementById("login-error").innerHTML = "email is not correct please check your @ sign and suffix/prefix";
    }
    else if(passcheck == null){

         document.getElementById("login-error").innerHTML = "Email does not exist";
    }

    else if(passcheck == password){

       {
         var loggedin = email+"logged";
         localStorage.setItem(loggedin,1);
         localStorage.setItem("login", email)
        window.location.href = "front.html";
       }
    }
    else{
        document.getElementById("login-error").innerHTML = "Password is incorrect";
    }
}

function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
     return re.test(email);
}

function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }

  