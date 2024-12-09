const container = document.querySelector("#container")

container.addEventListener("click", (event) => {
    event.target.style.backgroundColor = generateRandomColor();
  });

function generateRandomColor() {
    return '#'+(Math.random() * 0xFFFFFF << 0).toString(16).padStart(6, '0');
}