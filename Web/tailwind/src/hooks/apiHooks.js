import { fetchData } from '../utils/fetchData';

const useAuthentication = () => {
  const postLogin = async (credentials) => {
    return await fetchData(import.meta.env.VITE_AUTH_API + '/login', {
      method: 'POST',
      body: JSON.stringify(credentials),
    });
  };

  return { postLogin };
};

const useUser = () => {
  const getUserByToken = async (token) => {
    return await fetchData(import.meta.env.VITE_AUTH_API + '/users/token', {
      headers: {
        Authorization: 'Bearer ' + token,
      },
    });
  };

  return { getUserByToken };
};

const useMedia = () => {
  const deleteMedia = async (id, token) => {
    return await fetchData(import.meta.env.VITE_MEDIA_API + '/media/' + id, {
      method: 'DELETE',
      headers: {
        Authorization: 'Bearer ' + token,
      },
    });
  };

  const modifyMedia = async (id, data, token) => {
    return await fetchData(import.meta.env.VITE_MEDIA_API + '/media/' + id, {
      method: 'PUT',
      headers: {
        Authorization: 'Bearer ' + token,
      },
      body: JSON.stringify(data),
    });
  };

  return { deleteMedia, modifyMedia };
};

const useLike = () => {
  const postLike = async (media_id, token) => {
    return await fetchData(import.meta.env.VITE_MEDIA_API + '/likes', {
      method: 'POST',
      headers: {
        Authorization: 'Bearer ' + token,
      },
      body: JSON.stringify({ media_id }),
    });
  };

  const deleteLike = async (like_id, token) => {
    return await fetchData(import.meta.env.VITE_MEDIA_API + '/likes/' + like_id, {
      method: 'DELETE',
      headers: {
        Authorization: 'Bearer ' + token,
      },
    });
  };

  const getLikeCountByMediaId = async (media_id) => {
    return await fetchData(import.meta.env.VITE_MEDIA_API + '/likes/count/' + media_id);
  };

  const getLikeByUser = async (media_id, token) => {
    return await fetchData(import.meta.env.VITE_MEDIA_API + '/likes/user/' + media_id, {
      headers: {
        Authorization: 'Bearer ' + token,
      },
    });
  };

  return { postLike, deleteLike, getLikeCountByMediaId, getLikeByUser };
};

export { useAuthentication, useUser, useMedia, useLike };
