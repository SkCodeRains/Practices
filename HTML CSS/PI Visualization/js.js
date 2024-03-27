
// const canvas = document.getElementById('circleCanvas');
// const ctx = canvas.getContext('2d');
// const centerX = canvas.width / 2;
// const centerY = canvas.height / 2;
// const radius = 150;
// const angle = 0.1;

// function drawCircle() {
//     // ctx.clearRect(0, 0, canvas.width, canvas.height);
//     ctx.beginPath();
//     ctx.arc(centerX, centerY, radius, 0, 2 * Math.PI);
//     ctx.stroke();
// }

// function drawLine() {
//     ctx.beginPath();
//     ctx.moveTo(centerX, centerY);
//     const x = centerX + radius * Math.cos(angle);
//     const y = centerY + radius * Math.sin(angle);
//     ctx.lineTo(x, y);
//     ctx.stroke();
// }



// function animate() {
//     drawCircle();
//     drawLine();
//     angle += 0.1;
//     setTimeout(() => {
//         // window.requestAnimationFrame(animate);
//     }, 1000);
// }

// animate();



const canvas = document.getElementById('canvas');
const line = document.getElementById('line');
const radius = 150; // Adjust the radius as needed
const speed1 = 0.01; // Adjust the speed of the first line
const speed2 = 0.02; // Adjust the speed of the second line

let angle = 0;

function animate() {
    const x = radius * Math.cos(angle);
    const y = radius * Math.sin(angle);

    line.style.height = `${y}px`;
    line.style.transform = `translate(${x}px, 0) rotate(${angle}rad)`;

    angle += speed1;

    requestAnimationFrame(animate);
}

animate();