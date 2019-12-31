window.onload = () => {
    
    let verifyUser = () =>{
        let loginForm = document.loginForm;
        let userName = loginForm.userName.value;
        let password = loginForm.password.value;
        console.log("method called");
        let jsObject = {
            username: userName,
            password: password
        }
        let jsonStr = JSON.stringify(jsObject);
        let xhr = new XMLHttpRequest();
        let url = "http://localhost:8080/ProjectOne/main";
        xhr.onreadystatechange = ()=> {
            if(xhr.readyState === 4 && xhr.status === 200) {

                let text = xhr.responseText;
                console.log(xhr.response);
                console.log(text);
                //window.location.href = "http://localhost:8080/ProjectOne/employeeprofilepage.html";
                // console.log("Received Response From Server");
                
            }
        }
        console.log(jsonStr);
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhr.send(jsonStr);
    };
};