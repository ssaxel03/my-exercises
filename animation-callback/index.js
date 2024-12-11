const box = document.querySelector("#box");
const distance = document.querySelector("#container").getBoundingClientRect().width - box.getBoundingClientRect().width;
let distanceMoved = 0;
let direction = 1;

let moving = false;

function moveTimeout() {

    if(!moving) {return;}

    if (distanceMoved === distance) {

      if(direction === -1) {
        moving = false;
      }
      
      distanceMoved = 0;
      direction = direction * -1;

    }

    const actualPosition = parseInt(getComputedStyle(box).left);
    box.style.left = actualPosition + (1 * direction) + "px";
    distanceMoved++;
}

function seiLa() {
  const myInterval = setInterval(moveTimeout, 10);
  console.log("cenas");
}


window.onload = (event) => {
  box.addEventListener("click", () => {moving = true;});
};

seiLa();

