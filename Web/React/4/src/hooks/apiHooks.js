import { fetchData } from '../utils/fetchData';

const useAuthentication = () => {
  const postLogin = async (credentials) => {
    // This is a placeholder for the actual API call
    // In a real app, you would use fetchData here
    // return await fetchData(import.meta.env.VITE_AUTH_API + '/login', {
    //   method: 'POST',
    //   body: JSON.stringify(credentials),
    // });

    // Simple mock login for now
    if (credentials.username === 'admin' && credentials.password === 'admin') {
      return { token: 'mock-token', user: { username: 'admin', email: 'admin@metropolia.fi' } };
    }
    throw new Error('Login failed');
  };

  return { postLogin };
};

const useUser = () => {
  const getUserByToken = async (token) => {
    // Placeholder for getting user data by token
    if (token === 'mock-token') {
      return { user: { username: 'admin', email: 'admin@metropolia.fi' } };
    }
    throw new Error('Invalid token');
  };

  return { getUserByToken };
};

export { useAuthentication, useUser };
