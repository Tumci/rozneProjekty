var canvas = document.getElementById("canvas"); //znajdz element canvas
var context = canvas.getContext("2d"); //z ceelmentu canvas pobierz context 2d

var x = 0;
var y = 0;
var directionX = 1;
var directionY = 0;
var snake = [{x:3,y:0},{x:2,y:0}, {x:1,y:0}, {x:0,y:0}]; //długośc węża
var snakeElementSize = 20;
var gridHeight = canvas.height / snakeElementSize;
var gridWidth = canvas.width / snakeElementSize;
var gameOn = true;
var apple = applePosition();
let point = 0;

//co chwię odświerza grę
setInterval(update, 100);

//nasłuchiwanie klawiszy urzywanych na kalwiaturze
document.addEventListener("keypress",logPressKey);

//liczba punktów zdobytych w grze
document.querySelector("#score").innerHTML = point;

//rysowanie wężą
function drawRect(){
    context.clearRect(0,0,canvas.width, canvas.height);
    context.fillRect(x * snakeElementSize, y * snakeElementSize, snakeElementSize, snakeElementSize);
    x += directionX;
    y += directionY;
}

function updateSnake(snake){
    //głowa ma indeks 0, ustawiamy głowę w nowym położeniu
    for(let i = snake.length -1; i >0; i--){
        snake[i].x = snake[i -1].x;
        snake[i].y = snake[i-1].y;
    }
    snake[0].x += directionX;
    snake[0].y += directionY;
}

function update(){
    if(gameOn){
        context.clearRect(0,0,canvas.width, canvas.height);
        drawSnake(snake);
        updateSnake(snake);
        context.fillRect(apple.x * snakeElementSize, apple.y * snakeElementSize, snakeElementSize, snakeElementSize);
       //Jeżeli jabłko zostało zjedzone, to nadaj pozycje nowemu jabłku
        if(isAppleEaten()){
           apple = applePosition();
           snake.push({x:801,y:801});
           scorePoints();
       }
        gameOn = !isInWall(snake);
    }
}

function drawSnake(snake){
    context.clearRect(0,0, canvas.width, canvas.height);
    for(let i=0;i<snake.length;i++){
        //malowanie glowy węża na czarno
        if(i==0){
            context.fillRect(snake[i].x * snakeElementSize, snake[i].y * snakeElementSize,
            snakeElementSize, snakeElementSize);
            //malowanie pierwszego czlonu na szaro
        } else if(i==1){
            context.fillStyle = "rgba(0,0,0,0.5)";
            context.fillRect(snake[i].x * snakeElementSize, snake[i].y * snakeElementSize,
            snakeElementSize, snakeElementSize);
        }
        //malowanie każdego następnego elementu
        context.strokeRect(snake[i].x * snakeElementSize, snake[i].y * snakeElementSize,
        snakeElementSize, snakeElementSize);
    }
}

function logPressKey(event){
    if(event.key === "w"){
        console.log("Wciśnięto klawisz W");
        directionY = -1;
        directionX = 0;
    } else if(event.key === "s"){
        console.log("Wciśnięto klawisz s");
        directionY = 1
        directionX = 0;
    } else if(event.key === "a"){
        console.log("Wciśnięto klawisz a");
        directionX = -1;
        directionY = 0;
    } else if(event.key === "d"){
        console.log("Wciśnięto klawisz d");
        directionX = 1;
        directionY = 0;
    } else if(event.key === "q"){
        console.log("Wciśnięto klawisz q");
        directionX = 0;
        directionY = 0;
    } else if (event.key === "r"){
        console.log("Wciśnięto klawisz r");
        location.reload();
    }
}

function isInWall(snake){
    //jeżeli pozycja x głowy węża przekracza szerokość planszy
    //lub pozycja y 
    if(snake[0].x >= gridWidth || snake[0].y >= gridHeight || snake[0].x < 0 || snake[0].y < 0){
        return true;
    } else{
        return false;
    }
}

function applePosition(){
    let randomX = Math.random() * gridWidth;
    let randomY = Math.random() * gridHeight;
    return {x: Math.floor(randomX), y: Math.floor(randomY)};
}

function isAppleEaten(){
    if ((snake[0].x == apple.x) && (snake[0].y == apple.y)){
        context.clearRect(apple.x * snakeElementSize, apple.y * snakeElementSize, snakeElementSize, snakeElementSize);
        return true;
    }
}
function scorePoints(){
    point +=1;
    document.querySelector("#score").innerHTML = point;
}
