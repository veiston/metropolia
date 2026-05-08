import {useUserContext} from '../hooks/contextHooks';

const Profile = () => {
  const {user} = useUserContext();
  return (
    <>
      <h2>Profile</h2>
      {user && (
        <>
          <p>Username: {user.username}</p>
          <p>Email: {user.email}</p>
        </>
      )}
    </>
  );
};
export default Profile;
