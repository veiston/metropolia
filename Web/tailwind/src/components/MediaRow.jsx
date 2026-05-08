import {Link, useNavigate} from 'react-router';
import {useUserContext} from '../hooks/contextHooks';
import {useMedia} from '../hooks/apiHooks';

const MediaRow = (props) => {
  const {item} = props;
  const {user} = useUserContext();
  const {deleteMedia} = useMedia();
  const navigate = useNavigate();

  const handleDelete = async () => {
    if (window.confirm('Are you sure you want to delete this media?')) {
      try {
        const token = localStorage.getItem('token');
        await deleteMedia(item.media_id, token);
        navigate(0); // Refresh the page to show changes
      } catch (e) {
        console.error('Delete failed', e);
        alert('Delete failed: ' + e.message);
      }
    }
  };

  const handleModify = () => {
    console.log('modify', item);
    // In a real app, this might navigate to an edit page or open a modal
    alert('Modify functionality clicked for: ' + item.title);
  };

  return (
    <tr className="hover:bg-gray-700 transition-colors">
      <td className="p-4 border border-[#ccc] text-center">
        <img className="w-[260px] h-[200px] object-cover mx-auto rounded shadow-sm" src={item.thumbnail} alt={item.title} />
      </td>
      <td className="p-4 border border-[#ccc] text-center">{item.username}</td>
      <td className="p-4 border border-[#ccc] text-center font-bold">{item.title}</td>
      <td className="p-4 border border-[#ccc] text-center italic text-sm max-w-[200px] truncate">{item.description}</td>
      <td className="p-4 border border-[#ccc] text-center text-sm">{new Date(item.created_at).toLocaleString('fi-FI')}</td>
      <td className="p-4 border border-[#ccc] text-center text-sm">{Math.round(item.filesize / 1024)} KB</td>
      <td className="p-4 border border-[#ccc] text-center text-xs uppercase tracking-wider">{item.media_type}</td>
      <td className="p-4 border border-[#ccc] text-center">
        <div className="flex flex-col gap-2">
          <Link
            className="bg-[#363636] text-white p-2 no-underline hover:bg-[#111111] transition-colors rounded text-sm font-medium"
            to="/single"
            state={{item}}
          >
            View
          </Link>
          {user && (user.user_id === item.user_id || user.level_name === 'admin') && (
            <>
              <button
                className="bg-blue-700 text-white p-2 cursor-pointer hover:bg-blue-900 transition-colors rounded text-sm font-medium"
                onClick={handleModify}
              >
                Modify
              </button>
              <button
                className="bg-red-700 text-white p-2 cursor-pointer hover:bg-red-900 transition-colors rounded text-sm font-medium"
                onClick={handleDelete}
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
