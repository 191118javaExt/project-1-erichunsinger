window.onload = () => {

    var postman = new XMLHttpRequest();

    if(postman.status === 200 && postman. readyState === 4){

        document.getElementById("demo").innerHTML = xhttp.responseText;
    }
   // postman.open("GET", , true);
}


