const restaurants = [
  {
    name: 'Ravintola Ladonlukko',
    address: 'Latokartanonkaari 9 A',
    postalCode: '00790',
    city: 'Helsinki',
    phone: '+358 50 4653899',
    company: 'Sodexo',
  },
  {
    name: 'A Bloc',
    address: 'Otaniementie 12',
    postalCode: '02150',
    city: 'Espoo',
    phone: '-',
    company: 'Compass Group',
  },
  {
    name: 'Hanken',
    address: 'Arkadiankatu 22',
    postalCode: '00100',
    city: 'Helsinki',
    phone: '-',
    company: 'Compass Group',
  },
  {
    name: 'Ravintola Linna',
    address: 'Kalevantie 5',
    postalCode: '33100',
    city: 'Tampere',
    phone: '050 3185 913',
    company: 'Sodexo',
  },
  {
    name: 'Metropolia Myyrmäki',
    address: 'Leiritie 1',
    postalCode: '01600',
    city: 'Vantaa',
    phone: '050 300 8563',
    company: 'Sodexo',
  },
];

const listElement = document.querySelector('#restaurant-list');
const modal = document.querySelector('#restaurant-modal');
const details = document.querySelector('#restaurant-details');
const closeModalButton = document.querySelector('#close-modal-btn');

const sortedRestaurants = [...restaurants].sort((a, b) =>
  a.name.localeCompare(b.name, 'fi')
);

const showDetails = restaurant => {
  details.innerHTML = `
    <h2>${restaurant.name}</h2>
    <p>Address: ${restaurant.address}</p>
    <p>Postal code: ${restaurant.postalCode}</p>
    <p>City: ${restaurant.city}</p>
    <p>Phone: ${restaurant.phone}</p>
    <p>Company: ${restaurant.company}</p>
  `;
  modal.showModal();
};

sortedRestaurants.forEach(restaurant => {
  const item = document.createElement('li');
  item.innerHTML = `<strong>${restaurant.name}</strong><br>${restaurant.address}`;

  item.addEventListener('click', () => {
    listElement
      .querySelectorAll('li')
      .forEach(listItem => listItem.classList.remove('highlight'));
    item.classList.add('highlight');
    showDetails(restaurant);
  });

  listElement.append(item);
});

closeModalButton.addEventListener('click', () => {
  modal.close();
});
