const flags = [
  { name: "Argentina", file: "./src/flags/argentina.png" },
  { name: "Brazil", file: "./src/flags/brazil.png" },
  { name: "England", file: "./src/flags/england.png" },
  { name: "France", file: "./src/flags/france.png" },
  { name: "Germany", file: "./src/flags/germany.png" },
  { name: "Portugal", file: "./src/flags/portugal.png" },
  { name: "Spain", file: "./src/flags/spain.png" },
];

const select = document.getElementById("country-select");
const flagBox = document.getElementById("flag");
const randomBtn = document.getElementById("random-btn");

flags.forEach((flag, idx) => {
  const option = new Option(flag.name, idx);
  select.add(option);
});

function showFlag(index) {
  const flag = flags[index];
  if (!flag) {
    flagBox.textContent = "Pick a country above.";
    return;
  }
  flagBox.innerHTML = `<img src="${flag.file}" alt="${flag.name} flag" width="220" /><p>${flag.name}</p>`;
}

select.addEventListener("change", (e) => showFlag(e.target.value));
randomBtn.addEventListener("click", () => {
  const idx = Math.floor(Math.random() * flags.length);
  select.value = idx;
  showFlag(idx);
});

showFlag(); // initial message
