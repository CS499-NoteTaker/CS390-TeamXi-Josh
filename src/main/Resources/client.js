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
    ctx.moveTo(22, 0);
    ctx.lineTo(22, h);
    ctx.moveTo(44, 0);
    ctx.lineTo(44, h);
    ctx.moveTo(66, 0);
    ctx.lineTo(66, h);
    ctx.moveTo(88, 0);
    ctx.lineTo(88, h);
    ctx.moveTo(110, 0);
    ctx.lineTo(110, h);
    ctx.moveTo(132, 0);
    ctx.lineTo(132, h);
    ctx.moveTo(154, 0);
    ctx.lineTo(154, h);
    ctx.moveTo(176, 0);
    ctx.lineTo(176, h);
    ctx.moveTo(198, 0);
    ctx.lineTo(198, h);
    ctx.moveTo(220, 0);
    ctx.lineTo(220, h);
    ctx.moveTo(242, 0);
    ctx.lineTo(242, h);
    ctx.moveTo(264, 0);
    ctx.lineTo(264, h);
    ctx.moveTo(286, 0);
    ctx.lineTo(286, h);
    ctx.moveTo(308, 0);
    ctx.lineTo(308, h);
    ctx.moveTo(330, 0);
    ctx.lineTo(330, h);
    ctx.moveTo(352, 0);
    ctx.lineTo(352, h);
    ctx.moveTo(374, 0);
    ctx.lineTo(374, h);
    ctx.moveTo(396, 0);
    ctx.lineTo(396, h);

    ctx.moveTo(0, 22);
    ctx.lineTo(w, 22);
    ctx.moveTo(0, 44);
    ctx.lineTo(w, 44);
    ctx.moveTo(0, 66);
    ctx.lineTo(w, 66);
    ctx.moveTo(0, 88);
    ctx.lineTo(w, 88);
    ctx.moveTo(0, 110);
    ctx.lineTo(w, 110);
    ctx.moveTo(0, 132);
    ctx.lineTo(w, 132);
    ctx.moveTo(0, 154);
    ctx.lineTo(w, 154);
    ctx.moveTo(0,176);
    ctx.lineTo(w, 176);
    ctx.moveTo(0, 198);
    ctx.lineTo(w, 198);
    ctx.moveTo(0, 220);
    ctx.lineTo(w, 220);
    ctx.moveTo(0, 242);
    ctx.lineTo(w, 242);
    ctx.moveTo(0, 264);
    ctx.lineTo(w, 264);
    ctx.moveTo(0, 286);
    ctx.lineTo(w, 286);
    ctx.moveTo(0, 308);
    ctx.lineTo(w, 308);
    ctx.moveTo(0, 330);
    ctx.lineTo(w, 330);
    ctx.moveTo(0, 352);
    ctx.lineTo(w, 352);
    ctx.moveTo(0, 374);
    ctx.lineTo(w, 374);
    ctx.moveTo(0, 396);
    ctx.lineTo(w, 396);
    ctx.stroke();


};
document.addEventListener("DOMContentLoaded", main);