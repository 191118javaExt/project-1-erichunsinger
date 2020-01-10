

var username = document.getElementById("username");
var password = document.getElementById("password");
var btnTest = document.getElementById("btnTest");


btnTest.addEventListener("click", verifyUser);


function verifyUser() {
    
    console.log("method called");


    
    let jsObject = {
        
        "username": username.value,
        "password": password.value

    }
    let jsonStr = JSON.stringify(jsObject);
    let xhr = new XMLHttpRequest();
    let url = "login";
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {

            let text = xhr.responseText;
            console.log(xhr.response);

            window.location.href = "http://localhost:8080/ProjectOne/emphome.html";

            
        }
    }

    console.log(jsonStr);
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(jsonStr);
};
