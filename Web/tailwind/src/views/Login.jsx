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
      <h2 className="text-2xl font-bold text-center my-4">Login</h2>
      <form className="flex flex-col items-center justify-center" onSubmit={doLogin}>
        <div className="flex flex-col w-[80%] max-w-md">
          <label className="text-sm font-medium mb-1" htmlFor="username">Username</label>
          <input
            className="p-2.5 my-2.5 border border-[#ccc] rounded-md bg-transparent text-white"
            type="text"
            name="username"
            id="username"
            onChange={handleInputChange}
          />
        </div>
        <div className="flex flex-col w-[80%] max-w-md">
          <label className="text-sm font-medium mb-1" htmlFor="password">Password</label>
          <input
            className="p-2.5 my-2.5 border border-[#ccc] rounded-md bg-transparent text-white"
            type="password"
            name="password"
            id="password"
            onChange={handleInputChange}
          />
        </div>
        <button className="m-2.5 p-2.5 rounded-md bg-[#363636] text-white border-none cursor-pointer hover:bg-[#111111] transition-colors w-[80%] max-w-md" type="submit">Login</button>
      </form>
    </>
  );
};

export default Login;
