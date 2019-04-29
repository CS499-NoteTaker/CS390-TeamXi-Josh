var main = function(){
let btn = document.getElementById("test-button");
btn.addEventListener("click", buttonClickEvent);
};

var buttonClickEvent = function(e) {
    // Send a GET request to the server and display response in the
    // "response-area" span element.  For details about the fetch function
    // see:  https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch
    fetch("/leaderboard", { method: "GET"} )
        .then( function(response) {
              let el = document.getElementById("response-area");
              if( ! response.ok ) {
                  el.innerText = "Error code: " + response.status;
                  el.style.fontWeight = "bold";
                  el.style.color = "red";
              } else {
                  response.text().then( function(value) {
                      el.innerText = "Response: " + value;
                      el.style.color = "green";
                      el.style.fontWeight = "bold";
                  });
              }
            });
};


document.addEventListener("DOMContentLoaded", main);