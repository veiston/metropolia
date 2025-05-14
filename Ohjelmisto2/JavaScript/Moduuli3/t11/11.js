const picArray = [
  {
    title: "Title 1",
    caption: "Caption 1",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sodales enim eget leo condimentum vulputate. Sed lacinia consectetur fermentum. Vestibulum lobortis purus id nisi mattis posuere. Praesent sagittis justo quis nibh ullamcorper, eget elementum lorem consectetur. Pellentesque eu consequat justo, eu sodales eros.",
    image: {
      large: "img/pic1.jpg",
      medium: "thumbnails/pic1.jpg",
    },
  },
  {
    title: "Title 2",
    caption: "Caption 2",
    description:
      "Donec dignissim tincidunt nisl, non scelerisque massa pharetra ut. Sed vel velit ante. Aenean quis viverra magna. Praesent eget cursus urna. Ut rhoncus interdum dolor non tincidunt. Sed vehicula consequat facilisis. Pellentesque pulvinar sem nisl, ac vestibulum erat rhoncus id. Vestibulum tincidunt sapien eu ipsum tincidunt pulvinar. ",
    image: {
      large: "img/pic2.jpg",
      medium: "thumbnails/pic2.jpg",
    },
  },
  {
    title: "Title 3",
    caption: "Caption 3",
    description:
      "Phasellus imperdiet nunc tincidunt molestie vestibulum. Donec dictum suscipit nibh. Sed vel velit ante. Aenean quis viverra magna. Praesent eget cursus urna. Ut rhoncus interdum dolor non tincidunt. Sed vehicula consequat facilisis. Pellentesque pulvinar sem nisl, ac vestibulum erat rhoncus id. ",
    image: {
      large: "img/pic3.jpg",
      medium: "thumbnails/pic3.jpg",
    },
  },
  {
    title: "Title 4",
    caption: "Caption 4",
    description:
      "Duis sodales enim eget leo condimentum vulputate. Sed lacinia consectetur fermentum. Vestibulum lobortis purus id nisi mattis posuere. Praesent sagittis justo quis nibh ullamcorper, eget elementum lorem consectetur. Pellentesque eu consequat justo, eu sodales eros. Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
    image: {
      large: "img/pic4.jpg",
      medium: "thumbnails/pic4.jpg",
    },
  },
  {
    title: "Title 5",
    caption: "Caption 5",
    description:
      "Sed vel velit ante. Aenean quis viverra magna. Praesent eget cursus urna. Ut rhoncus interdum dolor non tincidunt. Sed vehicula consequat facilisis. Pellentesque pulvinar sem nisl, ac vestibulum erat rhoncus id. Vestibulum tincidunt sapien eu ipsum tincidunt pulvinar. Donec dignissim tincidunt nisl, non scelerisque massa pharetra ut. ",
    image: {
      large: "img/pic5.jpg",
      medium: "thumbnails/pic5.jpg",
    },
  },
  {
    title: "Title 6",
    caption: "Caption 6",
    description:
      "Sed vel velit ante. Aenean quis viverra magna. Praesent eget cursus urna. Ut rhoncus interdum dolor non tincidunt. Sed vehicula consequat facilisis. Pellentesque pulvinar sem nisl, ac vestibulum erat rhoncus id. Phasellus imperdiet nunc tincidunt molestie vestibulum. Donec dictum suscipit nibh.",
    image: {
      large: "img/pic6.jpg",
      medium: "thumbnails/pic6.jpg",
    },
  },
  {
    title: "Title 7",
    caption: "Caption 7",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sodales enim eget leo condimentum vulputate. Sed lacinia consectetur fermentum. Vestibulum lobortis purus id nisi mattis posuere. Praesent sagittis justo quis nibh ullamcorper, eget elementum lorem consectetur. Pellentesque eu consequat justo, eu sodales eros.",
    image: {
      large: "img/pic7.jpg",
      medium: "thumbnails/pic7.jpg",
    },
  },
  {
    title: "Title 8",
    caption: "Caption 8",
    description:
      "Praesent eget cursus urna. Ut rhoncus interdum dolor non tincidunt. Sed vehicula consequat facilisis. Pellentesque pulvinar sem nisl, ac vestibulum erat rhoncus id. Vestibulum tincidunt sapien eu ipsum tincidunt pulvinar. Donec dignissim tincidunt nisl, non scelerisque massa pharetra ut. Sed vel velit ante. Aenean quis viverra magna. ",
    image: {
      large: "img/pic8.jpg",
      medium: "thumbnails/pic8.jpg",
    },
  },
  {
    title: "Title 9",
    caption: "Caption 9",
    description:
      "Praesent eget cursus urna. Ut rhoncus interdum dolor non tincidunt. Sed vehicula consequat facilisis. Pellentesque pulvinar sem nisl, ac vestibulum erat rhoncus id. Phasellus imperdiet nunc tincidunt molestie vestibulum. Donec dictum suscipit nibh. Sed vel velit ante. Aenean quis viverra magna. ",
    image: {
      large: "img/pic9.jpg",
      medium: "thumbnails/pic9.jpg",
    },
  },
];

const osio = document.querySelector("#pictures");
const dialogi = document.querySelector("dialog");
const dialogiKuva = dialogi.querySelector("img");
const sulje = dialogi.querySelector("span");

picArray.forEach((k) => {
  const art = document.createElement("article");
  art.className = "card";

  const ots = document.createElement("h2");
  ots.textContent = k.title;

  const fig = document.createElement("figure");
  const img = document.createElement("img");
  img.src = k.image.medium;
  img.alt = k.title;
  img.dataset.large = k.image.large;
  const cap = document.createElement("figcaption");
  cap.textContent = k.caption;
  fig.appendChild(img);
  fig.appendChild(cap);

  const desc = document.createElement("p");
  desc.textContent = k.description;

  art.appendChild(ots);
  art.appendChild(fig);
  art.appendChild(desc);

  art.addEventListener("click", () => {
    dialogiKuva.src = k.image.large;
    dialogiKuva.alt = k.title;
    dialogi.showModal();
  });

  osio.appendChild(art);
});

sulje.addEventListener("click", () => {
  dialogi.close();
});
