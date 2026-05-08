import {Link, Outlet} from 'react-router';
import {useUserContext} from '../hooks/contextHooks';
import {useEffect} from 'react';

const Layout = () => {
  const {user, handleLogout, handleAutoLogin} = useUserContext();

  useEffect(() => {
    handleAutoLogin();
  }, []);

  return (
    <div>
      <nav className="bg-[#333333]">
        <ul className="flex justify-end list-none m-0 p-0 overflow-hidden *:block *:text-white *:text-center *:no-underline">
          <li>
            <Link className="block p-4 hover:bg-[#111111]" to="/">Home</Link>
          </li>
          {user ? (
            <>
              <li>
                <Link className="block p-4 hover:bg-[#111111]" to="/profile">Profile</Link>
              </li>
              <li>
                <Link className="block p-4 hover:bg-[#111111]" to="/upload">Upload</Link>
              </li>
              <li>
                <button className="block p-4 hover:bg-[#111111] cursor-pointer" onClick={handleLogout}>Logout</button>
              </li>
            </>
          ) : (
            <li>
              <Link className="block p-4 hover:bg-[#111111]" to="/login">Login</Link>
            </li>
          )}
        </ul>
      </nav>
      <main className="p-4">
        <Outlet />
      </main>
    </div>
  );
};
export default Layout;
