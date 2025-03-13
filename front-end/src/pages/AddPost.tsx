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
    <div className="flex items-center rounded-md bg-white pl-3 outline-1 -outline-offset-1 outline-gray-300 has-[input:focus-within]:outline-2 has-[input:focus-within]:-outline-offset-2 has-[input:focus-within]:outline-indigo-600">
      <form ref={NewPostForm} onSubmit={StudentHandler}>
        <h1>Add a Post</h1>

        <label htmlFor="author">Author</label>
        <input
          type="text"
          name="author"
          id="author"
          className="border-4 block min-w-0 grow py-1.5 pr-3 pl-1 text-base text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm/6"
          required
        />

        <label htmlFor="name">Title</label>
        <input
          type="text"
          name="names"
          id="names"
          className="border-4 block min-w-0 grow py-1.5 pr-3 pl-1 text-base text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm/6"
          required
        />

        <label htmlFor="content">Content</label>
        <textarea
          name="content"
          id="content"
          className="border-4 block min-w-0 grow py-1.5 pr-3 pl-1 text-base text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm/6"
          required
        />

        <button type="submit" className="bg-blue-500 text-white p-2 rounded-md">
          Add Post
        </button>
      </form>
    </div>
  );
};

export default AddPost;
