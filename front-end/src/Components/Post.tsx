import React from "react";
import "./Post.css";
import { PostType, usePosts } from "../PostContext.tsx";

const Post: React.FC<{ post: PostType }> = ({ post }) => {
  const { state, dispatch } = usePosts();

  function onSelect(post: PostType) {
    dispatch({ type: "SET_POST", post: post });
  }

  return (
    <div
      className={`border p-4 rounded-lg shadow-md cursor-pointer ${
        state.post && state.post === post ? "bg-green-200" : "bg-white"
      }`}
      onClick={() => onSelect(post)}
    >
      <h4 className="text-xl font-bold">{post.author}</h4>
      <p className="text-xl font-bold">{post.content}</p>
      <p>{post.content}</p>
    </div>
  );
};

export default Post;
