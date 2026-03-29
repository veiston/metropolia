const getMissingResource = async () => {
  try {
    const response = await fetch('https://reqres.in/api/unknown/23', {
      headers: {
        'x-api-key':
          'pro_a13bf586697b41e85cd0e289957446271e102e5722edddd1a9587e273426bf7d',
      },
    });

    if (!response.ok) {
      throw new Error(`Request failed with status ${response.status}`);
    }

    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('An error occurred:', error.message);
  }
};

getMissingResource();
