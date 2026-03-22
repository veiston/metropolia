const output = document.getElementById("output");
const celsiusInput = prompt("Enter temperature in Celsius:");
const celsius = Number(celsiusInput);

if (Number.isNaN(celsius)) {
  output.textContent = "Wroo! That won't work";
} else {
  const fahrenheit = (celsius * 9) / 5 + 32;
  const kelvin = celsius + 273.15;

  output.innerHTML = `
    <p>C: ${celsius.toFixed(2)} °C</p>
    <p>F: ${fahrenheit.toFixed(2)} °F</p>
    <p>K: ${kelvin.toFixed(2)} K</p>
  `;
}
