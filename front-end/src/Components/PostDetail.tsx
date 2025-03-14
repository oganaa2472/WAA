import React from "react";
import axios from "axios";
import { useRef, FormEvent ,useEffect,useState} from "react";
import { useNavigate } from "react-router";
import { usePosts, PostType } from '../PostContext.tsx';
const PostDetails: React.FC = () => {
    const {state, dispatch } = usePosts();
    const NewPostForm = useRef<HTMLFormElement | null>(null);
    const navigate = useNavigate();
    
    interface PostData {
      author: string;
      names: string;
      content: string;
    }
    const [formData, setFormData] = useState({
        author: "",
        name: "",
        content: "",
      });
    
      // Populate form when `state.post` changes
      useEffect(() => {
        if (state.post) {
          setFormData({
            author: state.post.author || "",
            name: state.post.name || "",
            content: state.post.content || "",
          });
        }
      }, [state.post]);
    // Handle form submission\
    const deletePost = (id:number)=>{
        axios
        .delete(`http://localhost:8080/api/posts/${id}`)
        .then((res) => {
          // Assuming res.data contains the new post object
          dispatch({ type: 'REMOVE_CONTACT', id: id });
          navigate("/");
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    }
    const StudentHandler = (e: FormEvent<HTMLFormElement>) => {
      e.preventDefault();
  
      if (!NewPostForm.current) return;
      const form = NewPostForm.current;
      const data: PostData = {
        author: form["author"].value,
        name: form["name"].value,
        content: form["content"].value,
        user_id:111
      };
  
      axios
        .put(`http://localhost:8080/api/posts/${state.post.id}`, data)
        .then((res) => {
          // Assuming res.data contains the new post object
          dispatch({ type: 'UPDATE_CONTACT', post: res.data });
          navigate("/");
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    };
    return (
        <div className="flex justify-center items-center min-h-screen bg-gray-100">
          {state.post ? (
            <form onSubmit={StudentHandler} ref={NewPostForm} className="w-full max-w-lg bg-white p-6 rounded-lg shadow-lg">
              <h1 className="text-3xl font-semibold text-gray-800 mb-6">{state.post.name}</h1>
      
              <label htmlFor="author" className="block text-sm font-medium text-gray-700 mb-2">Author</label>
              <input
                type="text"
                name="author"
                id="author"
                value={formData.author}
                onChange={(e) => setFormData({ ...formData, author: e.target.value })}
                className="w-full p-3 border-2 border-gray-300 rounded-md focus:ring-2 focus:ring-indigo-500 focus:outline-none transition duration-300 mb-4"
                required
              />
      
              <label htmlFor="name" className="block text-sm font-medium text-gray-700 mb-2">Title</label>
              <input
                type="text"
                name="name"
                id="name"
                value={formData.name}
                onChange={(e) => setFormData({ ...formData, name: e.target.value })}
                className="w-full p-3 border-2 border-gray-300 rounded-md focus:ring-2 focus:ring-indigo-500 focus:outline-none transition duration-300 mb-4"
                required
              />
      
              <label htmlFor="content" className="block text-sm font-medium text-gray-700 mb-2">Content</label>
              <textarea
                name="content"
                id="content"
                value={formData.content}
                onChange={(e) => setFormData({ ...formData, content: e.target.value })}
                className="w-full p-3 border-2 border-gray-300 rounded-md focus:ring-2 focus:ring-indigo-500 focus:outline-none transition duration-300 mb-6"
                required
              />
      
              <button type="submit" className="w-full p-3 bg-blue-500 text-white rounded-md hover:bg-blue-600 transition duration-300">
                Update Post
              </button>
              
              <button
                type="button"
                className="mt-4 w-full p-3 bg-red-500 text-white rounded-md hover:bg-red-600 transition duration-300"
                onClick={() => deletePost(state.post!.id)}
              >
                Delete Post
              </button>
            </form>
          ) : (
            <p className="text-xl font-semibold text-gray-600">No post selected</p>
          )}
        </div>
      );
      
  
};

export default PostDetails;
