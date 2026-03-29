const getUser = async () => {
  const response = await fetch('https://reqres.in/api/users/1', {
    headers: {
      'x-api-key':
        'pro_a13bf586697b41e85cd0e289957446271e102e5722edddd1a9587e273426bf7d',
    },
  });
  const data = await response.json();
  console.log(data);
};

getUser();
