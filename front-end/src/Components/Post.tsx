import React from 'react';


import './Post.css'
import { PostType } from '../types';
const Post: React.FC<{ post: PostType; onSelect: (post: PostType) => void }> = ({ post, onSelect }) => {
   return (
    <div className="border p-4 rounded-lg shadow-md cursor-pointer" 
    onClick={() => onSelect(post)}
    >
      <h3 className="text-xl font-bold">{post.title}</h3>
      <p>{post.author}</p>
    </div>
  );
}

export default Post;
