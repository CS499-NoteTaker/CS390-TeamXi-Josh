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

        let el = document.getElementById("f");
        if( ! response.ok ) {
            el.innerText = "Error code: " + response.status;
            el.style.fontWeight = "bold";
            el.style.color = "red";
        } else {
            response.json().then(function(data){
                var displayString = "1. " + data[0].userName;
                for(var i = 1; i < data.length; i++){
                    displayString += "\n" + (i + 1) + ". " + data[i].userName + " Wins: " + data[i].wins + " Losses: " +
                     data[i].losses;
                }
                el.value = displayString;
            })

        }
        });
};

Object.size = function(obj) {
    var size = 0, key;
    for (key in obj) {
        if (obj.hasOwnProperty(key)) size++;
    }
    return size;
};

document.addEventListener("DOMContentLoaded", main);
