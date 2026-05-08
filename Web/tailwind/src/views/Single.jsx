import {useLocation, useNavigate} from 'react-router';
import Likes from '../components/Likes';

const Single = () => {
  const {state} = useLocation();
  const navigate = useNavigate();

  const item = state.item;

  return (
    <div className="flex flex-col items-center">
      <h2 className="text-3xl font-bold my-4">{item.title}</h2>

      <div className="max-w-4xl w-full flex justify-center bg-black rounded-lg overflow-hidden shadow-2xl">
        {item.media_type.startsWith('image') ? (
          <img className="w-full h-auto max-h-[70vh] object-contain" src={item.filename} alt={item.title} />
        ) : (
          <video className="w-full h-auto max-h-[70vh]" controls>
            <source src={item.filename} type={item.media_type} />
          </video>
        )}
      </div>

      <div className="w-full max-w-4xl my-6 p-6 bg-[#333333] rounded-lg text-white shadow-md">
        <p className="text-xl leading-relaxed mb-4">{item.description}</p>
        <div className="flex justify-between items-center border-t border-gray-600 pt-4 mt-4">
          <p className="text-sm font-medium text-gray-400">Owner: <span className="text-white">{item.username}</span></p>
          <Likes item={item} />
        </div>
      </div>

      <button
        className="mb-8 px-6 py-2.5 rounded-md bg-[#363636] text-white hover:bg-[#111111] transition-colors cursor-pointer font-medium"
        onClick={() => navigate(-1)}
      >
        ← Go back
      </button>
    </div>
  );
};

export default Single;
