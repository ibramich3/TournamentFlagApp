const flags = [
  { name: "Argentina", file: "./src/flags/argentina.png" },
  { name: "Brazil", file: "./src/flags/brazil.png" },
  { name: "England", file: "./src/flags/england.png" },
  { name: "France", file: "./src/flags/france.png" },
  { name: "Germany", file: "./src/flags/germany.png" },
  { name: "Portugal", file: "./src/flags/portugal.png" },
  { name: "Spain", file: "./src/flags/spain.png" },
];

const selectEl = document.getElementById("country-select");
const flagDisplay = document.getElementById("flag-display");
const randomBtn = document.getElementById("random-flag");

function populateSelect() {
  flags.forEach((flag, index) => {
    const option = document.createElement("option");
    option.value = index;
    option.textContent = flag.name;
    selectEl.appendChild(option);
  });
}

function renderFlag(flag) {
  if (!flag) {
    flagDisplay.innerHTML = "<p>Select a country to preview its flag.</p>";
    return;
  }

  flagDisplay.innerHTML = `
    <img src="${flag.file}" alt="${flag.name} flag" />
    <p>${flag.name}</p>
  `;
}

selectEl.addEventListener("change", (event) => {
  const selectedIndex = Number(event.target.value);
  renderFlag(flags[selectedIndex]);
});

randomBtn.addEventListener("click", () => {
  const randomIndex = Math.floor(Math.random() * flags.length);
  selectEl.value = randomIndex;
  renderFlag(flags[randomIndex]);
});

populateSelect();
