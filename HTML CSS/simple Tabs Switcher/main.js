const btns = document.getElementsByClassName("tab");

for (const btn of btns) {
    btn.addEventListener("click", events);
}

function events(event) {
    for (const btn of btns) {
        if (btn.classList.contains("active")) {
            btn.classList.remove("active");
        }
    }
    event.srcElement.classList.add('active');
}