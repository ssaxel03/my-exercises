const playRound = document.getElementById("play-round");

const player1Image = document.getElementById("player1-image");
const player2Image = document.getElementById("player2-image");

const player1Score = document.getElementById("player1-score");
const player2Score = document.getElementById("player2-score");

const images = {"rock": "assets/rock.png", "paper": "assets/paper.png", "scissors": "assets/scissors.png"};
const moves = ["rock", "paper", "scissors"];

let player1ScoreValue = 0;
let player2ScoreValue = 0;

playRound.addEventListener("click", (event) => {
    let player1Hand = moves[Math.floor(Math.random() * 3)];
    let player2Hand = moves[Math.floor(Math.random() * 3)];

    player1Image.src = images[player1Hand];
    player2Image.src = images[player2Hand];

    switch(player1Hand) {
        case "rock":
            if(player2Hand === "paper") {
                player2ScoreValue++;
                player2Score.textContent = "Score: " + player2ScoreValue;
            }
            if(player2Hand === "scissors") {
                player1ScoreValue++;
                player1Score.textContent = "Score: " + player1ScoreValue;
            }
        case "paper":
            if(player2Hand === "rock") {
                player1ScoreValue++;
                player1Score.textContent = "Score: " + player1ScoreValue;
            }
            if(player2Hand === "scissors") {
                player2ScoreValue++;
                player2Score.textContent = "Score: " + player2ScoreValue;
            }
        case "scissors":
            if(player2Hand === "rock") {
                player2ScoreValue++;
                player2Score.textContent = "Score: " + player2ScoreValue;
            }
            if(player2Hand === "paper") {
                player1ScoreValue++;
                player1Score.textContent = "Score: " + player1ScoreValue;
            }
    };
})