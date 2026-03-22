const output = document.getElementById("output");
const celsiusInput = prompt("Enter temperature in Celsius:");
const celsius = Number(celsiusInput);

if (Number.isNaN(celsius)) {
  output.textContent = "Invalid input. Please enter a number.";
} else {
  const fahrenheit = (celsius * 9) / 5 + 32;
  const kelvin = celsius + 273.15;

  output.innerHTML = `
    <p>Celsius: ${celsius.toFixed(2)} °C</p>
    <p>Fahrenheit: ${fahrenheit.toFixed(2)} °F</p>
    <p>Kelvin: ${kelvin.toFixed(2)} K</p>
  `;
}
