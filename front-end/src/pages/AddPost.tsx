import axios from "axios";
import { useRef, FormEvent } from "react";
import { useNavigate } from "react-router";
import { usePosts, PostType } from '../PostContext.tsx';

const AddPost: React.FC = () => {
  const { dispatch } = usePosts();
  const NewPostForm = useRef<HTMLFormElement | null>(null);
  const navigate = useNavigate();

  interface PostData {
    author: string;
    names: string;
    content: string;
  }

  // Handle form submission
  const StudentHandler = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    if (!NewPostForm.current) return;
    const form = NewPostForm.current;
    const data: PostData = {
      author: form["author"].value,
      name: form["names"].value,
      content: form["content"].value,
      user_id:111
    };

    axios
      .post("http://localhost:8080/api/posts", data)
      .then((res) => {
        // Assuming res.data contains the new post object
        dispatch({ type: 'ADD_CONTACT', post: res.data });
        navigate("/");
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <div className="flex justify-center items-center min-h-screen bg-gray-100">
  <form ref={NewPostForm} onSubmit={StudentHandler} className="w-full max-w-lg bg-white p-6 rounded-lg shadow-lg">
    <h1 className="text-3xl font-semibold text-gray-800 mb-6">Add a Post</h1>

    <label htmlFor="author" className="block text-sm font-medium text-gray-700 mb-2">Author</label>
    <input
      type="text"
      name="author"
      id="author"
      className="w-full p-3 border-2 border-gray-300 rounded-md focus:ring-2 focus:ring-indigo-500 focus:outline-none transition duration-300 mb-4"
      required
    />

    <label htmlFor="names" className="block text-sm font-medium text-gray-700 mb-2">Title</label>
    <input
      type="text"
      name="names"
      id="names"
      className="w-full p-3 border-2 border-gray-300 rounded-md focus:ring-2 focus:ring-indigo-500 focus:outline-none transition duration-300 mb-4"
      required
    />

    <label htmlFor="content" className="block text-sm font-medium text-gray-700 mb-2">Content</label>
    <textarea
      name="content"
      id="content"
      className="w-full p-3 border-2 border-gray-300 rounded-md focus:ring-2 focus:ring-indigo-500 focus:outline-none transition duration-300 mb-6"
      required
    />

    <button
      type="submit"
      className="w-full p-3 bg-blue-500 text-white rounded-md hover:bg-blue-600 transition duration-300"
    >
      Add Post
    </button>
  </form>
</div>

  );
};

export default AddPost;
