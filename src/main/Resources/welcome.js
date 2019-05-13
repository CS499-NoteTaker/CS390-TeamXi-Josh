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
    ctx.fillText("⚫", 518, 356);
    ctx.fillText("⚪", 254, 224);
    ctx.fillText("⚫", 386, 488);
    ctx.fillText("⚪", 474, 708);
    ctx.fillText("⚫", 78, 840);
    ctx.fillText("⚪", 166, 576);
    ctx.fillText("⚫", 254, 840);
    ctx.fillText("⚪", 650, 796);
    ctx.fillText("⚫", 254, 532);
    ctx.fillText("⚪", 826, 180);
    ctx.fillText("⚫", 254, 444);
    ctx.fillText("⚪", 34, 224);
    ctx.fillText("⚫", 298, 576);
    ctx.fillText("⚪", 782, 136);
    ctx.fillText("⚫", 694, 488);
    ctx.fillText("⚪", 298, 136);
    ctx.fillText("⚫", 34, 444);
    ctx.fillText("⚪", 826, 532);
    ctx.fillText("⚫", 650, 576);
    ctx.fillText("⚪", 430, 400);
    ctx.fillText("⚫", 650, 620);
    ctx.fillText("⚪", 122, 268);
    ctx.fillText("⚫", 518, 576);
    ctx.fillText("⚪", 298, 268);
    ctx.fillText("⚫", 210, 576);
    ctx.fillText("⚪", 650, 796);
    ctx.fillText("⚫", 254, 620);
    ctx.fillText("⚪", 298, 136);
    ctx.fillText("⚫", 386, 48);
    ctx.fillText("⚪", 254, 488);
    ctx.fillText("⚫", 122, 224);
    ctx.fillText("⚪", 694, 312);



};

var buttonClickEvent = function(e) {
       var req = new XMLHttpRequest();
       var user = document.getElementById("login").value;
       req.open("POST", "/welcome/login");
       req.send(user);
       document.getElementById("CurrentUserName").value = document.getElementById("login").value;
       clearFields();
       window.name = document.getElementById("CurrentUserName").value;
       console.log(window.name);

};

function clearFields() {
     document.getElementById("login").value = "";
     document.getElementById("create").value = "";
};

var buttonClickCreate = function(e){
    var req = new XMLHttpRequest();
    var user = document.getElementById("create").value;
    console.log(user);
    req.open("POST", "/user");
    req.send(user);
    clearFields();

}


document.addEventListener("DOMContentLoaded", main);