const restaurantRow = (restaurant) => {
  const {name = 'Unknown', company = 'Unknown'} = restaurant;
  const row = document.createElement('tr');

  row.innerHTML = `
    <td>${name}</td>
    <td>${company}</td>
  `;

  return row;
};

const restaurantModal = (restaurant, menu) => {
  const {
    name = 'Unknown',
    address = 'Unknown address',
    postalCode = 'Unknown',
    city = 'Unknown city',
    phone = 'Unknown phone',
    company = 'Unknown company',
  } = restaurant;
  const {courses = []} = menu ?? {};

  let menuHtml = '<ul>';
  courses.forEach(({name: courseName = 'Unknown dish', price, diets}) => {
    const shownPrice = price ? price : '?€';
    const shownDiets = diets ? diets : 'No diet info';
    menuHtml += `<li>${courseName}, ${shownPrice}. ${shownDiets}</li>`;
  });

  if (courses.length === 0) {
    menuHtml += '<li>No menu available.</li>';
  }

  menuHtml += '</ul>';

  return `
    <h1>${name}</h1>
    <p>${address}</p>
    <p>${postalCode}, ${city}</p>
    <p>${phone}</p>
    <p>${company}</p>
    ${menuHtml}
  `;
};

export {restaurantRow, restaurantModal};