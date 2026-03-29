const fetchData = async (url, options = {}) => {
  const headers = {
    ...options.headers,
    'x-api-key':
      'pro_a13bf586697b41e85cd0e289957446271e102e5722edddd1a9587e273426bf7d',
  };

  const response = await fetch(url, {
    ...options,
    headers,
  });

  if (!response.ok) {
    throw new Error(`Request failed with status ${response.status}`);
  }

  return response.json();
};

const testFetchData = async () => {
  try {
    const user = {
      name: 'John Doe',
      job: 'Developer',
    };

    const url = 'https://reqres.in/api/users';
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(user),
    };

    const userData = await fetchData(url, options);
    console.log(userData);
  } catch (error) {
    console.error('An error occurred:', error.message);
  }
};

testFetchData();
