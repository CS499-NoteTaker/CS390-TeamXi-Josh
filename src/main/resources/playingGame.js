var main = function(){
    drawBoard();
    fillBoard();
    addPiecesToBoard();
        fillBoard();
    let btn = document.getElementById("submitbtn");
    btn.addEventListener("click", addPiecesToBoard);
    document.getElementById("CurrentUserName").value = window.name;

    //document.getElementById("CurrentUserName").value = window.name;
console.log(CurrentGameID)
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
    for (x=44;x<=880;x+=44) {
            for (y=44;y<=880;y+=44) {
                ctx.moveTo(x, 44);
                ctx.lineTo(x, h);
                ctx.stroke();
                ctx.moveTo(44, y);
                ctx.lineTo(w, y);
                ctx.stroke();
            }
        }
        ctx.font = "20px Arial";
        ctx.fillText("               1      2      3      4      5      6      7      8      9     10    11    12    13    14    15    16    17    18    19", 0, 30);
        ctx.fillText("1", 22, 88);
        ctx.fillText("2", 22, 132);
        ctx.fillText("3", 22, 176);
        ctx.fillText("4", 22, 220);
        ctx.fillText("5", 22, 264);
        ctx.fillText("6", 22, 308);
        ctx.fillText("7", 22, 352);
        ctx.fillText("8", 22, 396);
        ctx.fillText("9", 22, 440);
        ctx.fillText("10", 15, 484);
        ctx.fillText("11", 15, 528);
        ctx.fillText("12", 15, 572);
        ctx.fillText("13", 15, 616);
        ctx.fillText("14", 15, 660);
        ctx.fillText("15", 15, 704);
        ctx.fillText("16", 15, 748);
        ctx.fillText("17", 15, 792);
        ctx.fillText("18", 15, 836);
        ctx.fillText("19", 15, 880);
    ctx.stroke();


};

var addPiecesToBoard = function(e){
    var gameid = window.name;
    var s = "/current/" + gameid + "/placePoint";
    console.log(gameid);
    let canvas = document.getElementById("canvas-board");
    let ctx = canvas.getContext("2d");

        let x = document.getElementById("Xcord").value - 1;
        let y = document.getElementById("Ycord").value - 1;
        let coor = {x: x, y: y };
        let data = JSON.stringify(coor);
        console.log(data);
        fetch(s, { method: "POST", body: data} )
                    .then( function(response) {
                          if( ! response.ok ) {
                             console.log("no");
                          } else {
                                response.text().then( function(value) {
                                console.log("ok");

                                fillBoard();



                                // Calls getPiecesOnBoard resource method



                                    /*
                                    x = (x * 44) + 78;
                                    y = (y * 44) + 92;
                                    to make place on the right place on board ^
                                    ctx.fillText("", x, y);
                                    ⚫: black
                                    ⚪: white
                                    check which player then place piece
                                    */

                                 });
                              }
                          });





};



var placeBlack = function(X,Y){
    let canvas = document.getElementById("canvas-board");
    let ctx = canvas.getContext("2d");
    X = (X * 44) + 78;
    Y = (Y * 44) + 92;
    ctx.fillText("⚪", X, Y );
};

var placeWhite = function(X,Y){
    let canvas = document.getElementById("canvas-board");
    let ctx = canvas.getContext("2d");
    X = (X * 44) + 78;
    Y = (Y * 44) + 92;
    ctx.fillText("⚫", X, Y );
};


var fillBoard = function() {
    var gameid = window.name;
    var getPointsUrl = "/current/" + gameid + "/occupiedPoints";

    fetch(getPointsUrl, { method: "GET" })
         .then( function(response)  {

             if( !response.ok) {
                 console.log("Error: wasn't able to get OccupiedPoints approprately")
             } else {
                 var pointX = 0;
                 var pointY = 0;
                 var pointPiece = "";
                 response.json().then(function(pointsData) {
                 console.log("pointsData size: " + pointsData.length)
                 for(var i = 0; i < pointsData.length; i++) {
                    console.log( pointsData[i] );
                    pointX = ( (pointsData[i].x + 1) * 44) + 78;
                    pointY = ( (pointsData[i].y + 1) * 44) + 92;

                    console.log(pointX + " " + pointY);
                    pointPiece = pointsData[i].piece
                                            placeBlack( pointX, pointY);


                    if (pointPiece == "B") {
                        placeBlack( pointX, pointY);
                    } else { //(pointPiece == "W") {
                        placeWhite( pointX, pointY );
                    }



                 }



                 })





             }


         });


};

document.addEventListener("DOMContentLoaded", main);