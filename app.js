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

if (!select || !flagBox || !randomBtn) {
  throw new Error("Required DOM nodes are missing. Ensure index.html is intact.");
}

const placeholder = new Option("Pick a country…", "", true, true);
placeholder.disabled = true;
select.add(placeholder);

flags.forEach((flag, idx) => {
  const option = new Option(flag.name, String(idx));
  option.dataset.flag = flag.file;
  select.add(option);
});

function showFlag(idxLike) {
  const idx = Number(idxLike);
  const flag = Number.isInteger(idx) && idx >= 0 ? flags[idx] : null;
  if (!flag) {
    flagBox.textContent = "Pick a country above or tap random.";
    return;
  }
  flagBox.innerHTML = `<img src="${flag.file}" alt="${flag.name} flag" width="240" /><p>${flag.name}</p>`;
}

select.addEventListener("change", (e) => showFlag(e.target.value));
randomBtn.addEventListener("click", () => {
  const idx = Math.floor(Math.random() * flags.length);
  select.value = String(idx);
  showFlag(idx);
});

showFlag(null);
