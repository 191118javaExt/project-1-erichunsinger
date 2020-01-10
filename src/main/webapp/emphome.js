user = "Eric";
welcomeBack = document.getElementById("welcomeBack").innerHTML = "Welcome Back " + user;
var navBar = document.getElementById("navBar");
var tickets = document.getElementById("tickets");
tickets.addEventListener("click", ticketsPage, getAllTickets);

function getAllTickets (){

    console.log("Method Called");
    

    var postman = new XMLHttpRequest();
    postman.onreadystatechange = function () {

        if(postman.status === 200 && postman.readyState === 4){

            postman.addEventListener("load", getAllTickets);
            postman.open("GET", "http://localhost:8080/ProjectOne/profile", true);
            window.location.href = "http://localhost:8080/ProjectOne/emptickpage.html";
        }
    }
    postman.send();


}

function ticketsPage () {


}
/*
window.onload = () => {

    welcomeBack;

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange() {

        if(xhr.status === 200 && xhr.readyState === 4){

            //Populate the table
            var response = xhr.responseText;
            xhr.open("GET" URLofServlet, true);
        };

        xhr.send();
    } 
} */