import { useEffect, useState } from 'react';
import { useLike } from '../hooks/apiHooks';
import { useUserContext } from '../hooks/contextHooks';

const Likes = ({ item }) => {
  const [likeCount, setLikeCount] = useState(0);
  const [userLike, setUserLike] = useState(null);
  const { postLike, deleteLike, getLikeCountByMediaId, getLikeByUser } = useLike();
  const { user } = useUserContext();

  const getLikes = async () => {
    try {
      const count = await getLikeCountByMediaId(item.media_id);
      setLikeCount(count.count);
      if (user) {
        const token = localStorage.getItem('token');
        const userLikeResult = await getLikeByUser(item.media_id, token);
        setUserLike(userLikeResult);
      }
    } catch (error) {
      console.error('getLikes error', error);
    }
  };

  const handleLike = async () => {
    try {
      const token = localStorage.getItem('token');
      if (userLike) {
        await deleteLike(userLike.like_id, token);
      } else {
        await postLike(item.media_id, token);
      }
      getLikes();
    } catch (error) {
      console.error('handleLike error', error);
    }
  };

  useEffect(() => {
    getLikes();
  }, [item, user]);

  return (
    <div className="flex items-center gap-4">
      <p className="font-bold">Likes: {likeCount}</p>
      {user && (
        <button
          className={`px-4 py-2 rounded-md transition-colors cursor-pointer ${
            userLike ? 'bg-red-600 hover:bg-red-800' : 'bg-[#363636] hover:bg-[#111111]'
          } text-white font-medium`}
          onClick={handleLike}
        >
          {userLike ? '❤️ Unlike' : '🤍 Like'}
        </button>
      )}
    </div>
  );
};

export default Likes;
