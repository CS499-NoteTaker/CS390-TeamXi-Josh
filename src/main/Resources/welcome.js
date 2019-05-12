var main = function(){
    drawBoard();
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
    ctx.font = "15px Arial";
    ctx.fillText("⚫", 3, 18);
    ctx.fillText("⚪", 3, 85);
    ctx.fillText("⚪", 3, 40);
    ctx.fillText("⚫", 113, 40);
    ctx.fillText("⚪", 113, 172);
    ctx.fillText("⚫", 157, 216);
    ctx.fillText("⚪", 200, 150);
    ctx.fillText("⚪", 135, 216);
    ctx.fillText("⚫", 47, 62);
    ctx.fillText("⚫", 311, 238);
    ctx.fillText("⚪", 399, 414);
    ctx.fillText("⚫", 311, 83);



};
document.addEventListener("DOMContentLoaded", main);