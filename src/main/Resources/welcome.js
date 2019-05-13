var main = function(){
    drawBoard();
    let btn = document.getElementById("loginbtn");
    btn.addEventListener("click", buttonClickEvent);
    let createBtn = document.getElementById("createbtn");
    createBtn.addEventListener("click", buttonClickCreate);
};

var drawBoard = function(){
    let canvas = document.getElementById("canvas-board");

    let ctx = canvas.getContext("2d");
    let w = canvas.width;
    let h = canvas.height;

    ctx.fillStyle = "rgb(255, 255, 255)";
    ctx.fillRect(0, 0, w, h);

    ctx.fillStyle = "rgb(0,0,0)";
    ctx.beginPath();
    for (x=0;x<=w;x+=44) {
            for (y=0;y<=h;y+=44) {
                ctx.moveTo(x, 0);
                ctx.lineTo(x, h);
                ctx.stroke();
                ctx.moveTo(0, y);
                ctx.lineTo(w, y);
                ctx.stroke();
            }
        }
    ctx.stroke();
    ctx.font = "20px Arial";
    /*
    To place a piece on the cross: correct by taking 10 pixels
    from the x, and adding 4 pixels to the y
    */
    ctx.fillText("⚫", 34, 48);
    ctx.fillText("⚪", 78, 92);
   /* ctx.fillText("⚪", 3, 40);
    ctx.fillText("⚫", 113, 40);
    ctx.fillText("⚪", 113, 172);
    ctx.fillText("⚫", 157, 216);
    ctx.fillText("⚪", 200, 150);
    ctx.fillText("⚪", 135, 216);
    ctx.fillText("⚫", 47, 62);
    ctx.fillText("⚫", 311, 238);
    ctx.fillText("⚪", 399, 414);
    ctx.fillText("⚫", 311, 83);*/



};

var buttonClickEvent = function(e) {
      /* var req = new XMLHttpRequest();
       var user = document.getElementById("login").value;

       console.log(user);

       req.open("GET", "/user");
       req.send(user);
       alert("Welcome " + user + "!");
       clearFields();*/
       let user = document.getElementById("login").value;


        fetch("/user/{user}", { method: "GET"} )
               .then( function(response) {
               if( ! response.ok ) {
                   alert("Incorrect user");
               } else {
                  /* response.json().then(function(data){
                       for(var i = 1; i < data.length; i++){
                           displayString += "\n" + (i + 1) + ". " + data[i].userName + " Wins: " + data[i].win + " Losses: " +
                            data[i].loss;
                       }
                       el.value = displayString;
                   })*/

                    alert("Welcome " + response + "!");
               }
               });
               clearFields();
};

function clearFields() {

     document.getElementById("login").value = "";
     document.getElementById("create").value = "";
};


var buttonClickCreate = function(e){
    var req = new XMLHttpRequest();
    var user = document.getElementById("create").value;

    console.log(user);

    alert("Welcome " + user + "!");
    req.open("POST", "/user");
    req.send(user);
    clearFields();

}


document.addEventListener("DOMContentLoaded", main);