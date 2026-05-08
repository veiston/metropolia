import {Link} from 'react-router';
import {useUserContext} from '../hooks/contextHooks';

const MediaRow = (props) => {
  const {item} = props;
  const {user} = useUserContext();

  return (
    <tr className="hover:bg-gray-700">
      <td className="p-4 border border-[#ccc] text-center">
        <img className="w-[260px] h-[200px] object-cover mx-auto" src={item.thumbnail} alt={item.title} />
      </td>
      <td className="p-4 border border-[#ccc] text-center">{item.username}</td>
      <td className="p-4 border border-[#ccc] text-center font-bold">{item.title}</td>
      <td className="p-4 border border-[#ccc] text-center italic">{item.description}</td>
      <td className="p-4 border border-[#ccc] text-center">{new Date(item.created_at).toLocaleString('fi-FI')}</td>
      <td className="p-4 border border-[#ccc] text-center">{Math.round(item.filesize / 1024)} KB</td>
      <td className="p-4 border border-[#ccc] text-center">{item.media_type}</td>
      <td className="p-4 border border-[#ccc] text-center">
        <div className="flex flex-col gap-2">
          <Link
            className="bg-[#363636] text-white p-2 no-underline hover:bg-[#111111] transition-colors"
            to="/single"
            state={{item}}
          >
            View
          </Link>
          {user && (user.user_id === item.user_id || user.level_name === 'admin') && (
            <>
              <button
                className="bg-[#363636] text-white p-2 cursor-pointer hover:bg-[#111111] transition-colors"
                onClick={() => console.log("modify", item)}
              >
                Modify
              </button>
              <button
                className="bg-[#363636] text-white p-2 cursor-pointer hover:bg-[#111111] transition-colors"
                onClick={() => console.log("delete", item)}
              >
                Delete
              </button>
            </>
          )}
        </div>
      </td>
    </tr>
  );
};

export default MediaRow;
