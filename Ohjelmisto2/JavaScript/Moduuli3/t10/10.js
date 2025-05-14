const lomake = document.querySelector("form");
lomake.addEventListener("submit", function (e) {
  e.preventDefault();
  const etunimi = document.querySelector("[name='firstname']").value;
  const sukunimi = document.querySelector("[name='lastname']").value;
  document.getElementById(
    "target"
  ).textContent = `Your name is ${etunimi} ${sukunimi}`;
});
