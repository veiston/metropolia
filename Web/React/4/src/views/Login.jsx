import {useState} from 'react';
import {useUserContext} from '../hooks/contextHooks';

const Login = () => {
  const {handleLogin} = useUserContext();
  const [inputs, setInputs] = useState({username: '', password: ''});

  const doLogin = async (event) => {
    event.preventDefault();
    try {
      await handleLogin(inputs);
    } catch (e) {
      alert(e.message);
    }
  };

  const handleInputChange = (event) => {
    setInputs((inputs) => ({
      ...inputs,
      [event.target.name]: event.target.value,
    }));
  };

  return (
    <>
      <h2>Login</h2>
      <form onSubmit={doLogin}>
        <div>
          <label htmlFor="username">Username</label>
          <input
            type="text"
            name="username"
            id="username"
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="password">Password</label>
          <input
            type="password"
            name="password"
            id="password"
            onChange={handleInputChange}
          />
        </div>
        <button type="submit">Login</button>
      </form>
    </>
  );
};

export default Login;
