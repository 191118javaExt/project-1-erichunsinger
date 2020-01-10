window.onload = {


}

function getAllEmployees () {

    console.log("Method Called");
    

    var postman = new XMLHttpRequest();
    postman.onreadystatechange = function () {

        if(postman.status === 200 && postman.readyState === 4){

            postman.addEventListener("load", getAllEmployees);
            postman.open("GET", "http://localhost:8080/ProjectOne/profile", true);
            window.location.href = "http://localhost:8080/ProjectOne/emptickpage.html";
        }
    }
    postman.send();


}