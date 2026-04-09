import {restaurantModal, restaurantRow} from './components.js';
import {fetchData} from './utils.js';
import {baseUrl} from './variables.js';

const tableBody = document.querySelector('#restaurant-table tbody');
const modal = document.querySelector('#restaurant-modal');
const modalContent = document.querySelector('#restaurant-modal-content');
const closeModalButton = document.querySelector('#close-modal-btn');
const messageElement = document.querySelector('#message');
const filterButtons = document.querySelectorAll('[data-filter]');

let restaurants = [];
let selectedRow = null;
let activeFilter = 'all';

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

const updateActiveFilterButton = () => {
  filterButtons.forEach((button) => {
    const {filter} = button.dataset;
    const shouldBeActive = filter === activeFilter;

    button.classList.toggle('active', shouldBeActive);
  });
};

const getFilteredRestaurants = () => {
  if (activeFilter === 'all') {
    return restaurants;
  }

  return restaurants.filter(({company = ''}) => {
    return company.toLowerCase().includes(activeFilter);
  });
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

const renderRestaurants = (restaurantList) => {
  if (!tableBody) {
    return;
  }

  clearHighlight();
  tableBody.innerHTML = '';

  const rows = restaurantList.map((restaurant) => {
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

const applyFilter = (filterValue) => {
  if (!restaurants.length) {
    setMessage('Restaurant data is not loaded yet.', true);
    return;
  }

  activeFilter = filterValue;
  updateActiveFilterButton();
  const filteredRestaurants = getFilteredRestaurants();
  renderRestaurants(filteredRestaurants);
  setMessage(`Showing ${filteredRestaurants.length} restaurants.`);
};

const bindFilters = () => {
  filterButtons.forEach((button) => {
    button.addEventListener('click', () => {
      const {filter} = button.dataset;

      if (!filter) {
        setMessage('Invalid filter button.', true);
        return;
      }

      applyFilter(filter);
    });
  });
};

const init = async () => {
  bindFilters();

  try {
    setMessage('Loading restaurants...');
    const restaurantData = await fetchData(`${baseUrl}/restaurants`);
    restaurants = restaurantData;
    applyFilter(activeFilter);
  } catch (error) {
    setMessage(`Restaurant loading failed: ${error.message}`, true);
  }
};

closeModalButton?.addEventListener('click', () => {
  modal?.close();
});

init();