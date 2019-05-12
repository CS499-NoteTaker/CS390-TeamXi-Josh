var main = function(){
    drawBoard();
};

window.onload = function(){
    canvas = document.getElementById("canvas-board");
    ctx = canvas.getContext("2d");
    canvas.addEventListener('click', handleClick);
}

function getMousePos(c, evt){
   var rect = canvas.getBoundingClientRect(),
         scaleX = canvas.width / rect.width,
         scaleY = canvas.height / rect.height;
    return{
        x: (evt.clientX - rect.left) * scaleX,
        y: (evt.clientY - rect.top) * scaleY
    };
}

function handleClick(e){
    var pos = getMousePos(canvas, e)
    posx = pos.x;
    posy = pos.y;

    console.log(posx + " " +posy)

    ctx.font = "15px Arial";
            ctx.fillText("⚫", posx - 6, posy + 10);


    if(posx / 44 >= 44/2){
        posx = ((Math.ceil(posx/44) * 44) + 44) / 44;
    }
    else{
       posx = ((Math.floor(posx/44) * 44) + 44) / 44;
    }

    if(posy % 44 >= 44/2){
            posy = ((Math.ceil(posy/44) * 44) + 44) / 44;
        }
        else{
           posy = ((Math.floor(posy/44) * 44) + 44) / 44;
        }

    console.log(posx + " " +posy)

    //ctx.font = "15px Arial";
    //    ctx.fillText("⚫", posx, posy);

    return {x: posx, y: posy};
}

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


};


document.addEventListener("DOMContentLoaded", main);