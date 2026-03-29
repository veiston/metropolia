const output =
  document.getElementById("output") ||
  (() => {
    const element = document.createElement("div");
    element.id = "output";
    document.body.appendChild(element);
    return element;
  })();

const movieCount = Number(prompt("How many movies do you want to rate?"));

if (!Number.isInteger(movieCount) || movieCount <= 0) {
  output.textContent = "Wroo! That won't work";
} else {
  const movies = [];

  for (let i = 1; i <= movieCount; i += 1) {
    const titleInput = prompt(`Enter title for movie ${i}:`);
    const title =
      titleInput && titleInput.trim() ? titleInput.trim() : `Movie ${i}`;

    const ratingInput = Number(prompt(`Enter rating for \"${title}\" (1-5):`));
    let rating = ratingInput;

    if (Number.isNaN(rating)) {
      rating = 1;
    }

    if (rating < 1) {
      rating = 1;
    }

    if (rating > 5) {
      rating = 5;
    }

    movies.push({ title, rating });
  }

  const sortedMovies = [...movies].sort((a, b) => b.rating - a.rating);
  const highestRatedMovie = sortedMovies[0];

  output.innerHTML = `
		<h2>Movies by rating :')</h2>
		<ul>
			${sortedMovies.map((movie) => `<li>${movie.title}: ${movie.rating}/5</li>`).join("")}
		</ul>
		<p>Top movie: ${highestRatedMovie.title} (${highestRatedMovie.rating}/5)</p>
	`;
}
