import {restaurantModal, restaurantRow} from './components.js';
import {fetchData} from './utils.js';
import {baseUrl} from './variables.js';

const tableBody = document.querySelector('#restaurant-table tbody');
const modal = document.querySelector('#restaurant-modal');
const modalContent = document.querySelector('#restaurant-modal-content');
const closeModalButton = document.querySelector('#close-modal-btn');
const messageElement = document.querySelector('#message');

let selectedRow = null;

const setMessage = (message, isError = false) => {
  if (!messageElement) {
    return;
  }

  messageElement.textContent = message;
  messageElement.className = isError ? 'message error' : 'message';
};

const clearHighlight = () => {
  if (!selectedRow) {
    return;
  }

  selectedRow.classList.remove('highlight');
  selectedRow = null;
};

const openRestaurantModal = async (restaurant) => {
  try {
    const menu = await fetchData(`${baseUrl}/restaurants/daily/${restaurant._id}/fi`);
    if (modalContent) {
      modalContent.innerHTML = restaurantModal(restaurant, menu);
    }

    modal?.showModal();
  } catch (error) {
    if (modalContent) {
      modalContent.innerHTML = restaurantModal(restaurant, {courses: []});
    }

    modal?.showModal();
    setMessage(`Menu loading failed: ${error.message}`, true);
  }
};

const renderRestaurants = (restaurants) => {
  if (!tableBody) {
    return;
  }

  tableBody.innerHTML = '';
  const rows = restaurants.map((restaurant) => {
    const row = restaurantRow(restaurant);

    row.addEventListener('click', async () => {
      clearHighlight();
      selectedRow = row;
      selectedRow.classList.add('highlight');
      await openRestaurantModal(restaurant);
    });

    return row;
  });

  rows.forEach((row) => {
    tableBody.append(row);
  });
};

const init = async () => {
  try {
    setMessage('Loading restaurants...');
    const restaurants = await fetchData(`${baseUrl}/restaurants`);
    renderRestaurants(restaurants);
    setMessage('');
  } catch (error) {
    setMessage(`Restaurant loading failed: ${error.message}`, true);
  }
};

closeModalButton?.addEventListener('click', () => {
  modal?.close();
});

init();