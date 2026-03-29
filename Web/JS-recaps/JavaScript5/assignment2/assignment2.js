const createUser = async () => {
  const user = {
    name: 'John Doe',
    job: 'Developer',
  };

  const response = await fetch('https://reqres.in/api/users', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'x-api-key':
        'pro_a13bf586697b41e85cd0e289957446271e102e5722edddd1a9587e273426bf7d',
    },
    body: JSON.stringify(user),
  });

  const data = await response.json();
  console.log(data);
};

createUser();
