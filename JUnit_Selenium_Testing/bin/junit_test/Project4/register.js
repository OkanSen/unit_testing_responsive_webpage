function submitForm(){
    var email = document.getElementById("email1").value;
    var password = document.getElementById("password1").value;
    var repassword = document.getElementById("password2").value;
    var label = document.getElementById("login-error").value;
    if (email == "" || email.trim() == '' || password== "")
    {
        document.getElementById("login-error").innerHTML = "Email or password cannot be empty";
    }
    else if(!validateEmail(email))
    {
        document.getElementById("login-error").innerHTML = "email is not correct please check your @ sign and suffix/prefix";
    }
    else if(password != repassword)
    {
        document.getElementById("login-error").innerHTML = "Passwords do not match";
    }
    else if(localStorage.getItem(email) != null)
    {
        document.getElementById("login-error").innerHTML = "email is already registerted";
    }
    else{
        localStorage.setItem(email, password);
        document.getElementById("login-error").innerHTML = "You have been successfully registered";
    }
}

function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
     return re.test(email);
}

